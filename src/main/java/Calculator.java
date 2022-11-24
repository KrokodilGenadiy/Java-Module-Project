import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final HashMap<String, Double> bucket = new HashMap<>();
    private double sum = 0;

    public void addProduct(String name, Double price) {
        bucket.merge(name, price, Double::sum);
        sum += price;
    }

    public void printAllEntries() {
        for (Map.Entry<String, Double> product : bucket.entrySet()) {
            int lastDigit = product.getValue().intValue() % 10;
            if (lastDigit == 1) {
                System.out.printf(product.getKey() + " " + "%.2f рубль\n", product.getValue());
                continue;
            }
            if (lastDigit < 5)
                System.out.printf(product.getKey() + " " + "%.2f рубля\n", product.getValue());
            else
                System.out.printf(product.getKey() + " " + "%.2f рублей\n", product.getValue());
        }
    }

    public void printBill(int divider) {
        double result = sum / (double) divider;
        int lastDigit = (int) (result % 10);
        if (lastDigit == 1) {
            System.out.printf("Каждый должен заплатить %.2f рубль\n", result);
            return;
        }
        if (lastDigit < 5)
            System.out.printf("Каждый должен заплатить %.2f рубля\n", result);
        else
            System.out.printf("Каждый должен заплатить %.2f рублей\n", result);
    }
}
