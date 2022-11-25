import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final static HashMap<String, Double> bucket = new HashMap<>();
    private static double sum = 0;
    private final static String billBeginning = "Каждый должен заплатить ";

    public static void addProduct(String name, Double price) {
        bucket.merge(name, price, Double::sum);
        sum += price;
    }

    public static void printAllEntries() {
        for (Map.Entry<String, Double> product : bucket.entrySet()) {
            int lastDigit = product.getValue().intValue() % 10;
            int penultimateDigit = (product.getValue().intValue() / 10) % 10;
            if (lastDigit == 1 && penultimateDigit != 1) {
                System.out.printf(product.getKey() + " %.2f рубль\n", product.getValue());
                continue;
            }
            if (lastDigit >= 5 || penultimateDigit == 1 || lastDigit == 0)
                System.out.printf(product.getKey() + " %.2f рублей\n", product.getValue());
            else
                System.out.printf(product.getKey() + " %.2f рубля\n", product.getValue());
        }
        System.out.println();
    }


    public static void getBill(int divider) {
        double result = sum / (double) divider;
        int lastDigit = (int) (result % 10);
        int penultimateDigit = (int) ((result / 10) % 10);
        if (lastDigit == 1 && penultimateDigit != 1) {
            printBill(String.format("%.2f рубль\n", result));
            return;
        }
        if (lastDigit >= 5 || penultimateDigit == 1 || lastDigit == 0)
            printBill(String.format("%.2f рублей\n", result));
        else
            printBill(String.format("%.2f рубля\n", result));
    }

    private static void printBill(String ending) {
        System.out.println(billBeginning + ending);
    }

}
