import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private final static String endMe = "Завершить";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfGuests = getGuests(reader);
        addProducts( reader);
        System.out.println("Добавленные товары:\n");
        Calculator.printAllEntries();
        Calculator.getBill(numberOfGuests);
    }

    private static int getGuests(BufferedReader reader) throws IOException {
        int result;
        try {
            while (true) {
                System.out.println("Введите кол-во человек:");
                result = readInt(reader);
                if (result <= 1)
                    System.out.println("Для такого кол-во человек не имеет смысла считать");
                else
                    break;
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println("Некорректный  ввод");
            return getGuests(reader);
        }
    }

    private static void addProducts(BufferedReader reader) throws IOException {
        add(reader);
        while (true) {
            System.out.println("Хотите добавить ещё товар?");
            String choice = reader.readLine();
            if (choice.equalsIgnoreCase(endMe))
                break;
            else
                add(reader);
        }
    }

    private static void add(BufferedReader reader) throws IOException {
        try {
            System.out.println("Введите наименование товара:");
            String name = reader.readLine();
            while (true) {
                System.out.println("Введите цену товара:");
                double price = readDouble(reader);
                if (price > 0) {
                    Calculator.addProduct(name, price);
                    break;
                }
                System.out.println("Цена товара должна быть больше нуля!");
            }
            System.out.println("Товар успешно добавлен!");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            add(reader);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static double readDouble(BufferedReader reader) throws IOException {
        return Double.parseDouble(reader.readLine());
    }
}
