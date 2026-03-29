package Bai09;
import java.util.*;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String getDetails();
}

class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }
    public String getDetails() {
        return expiryDate;
    }
}

class Electronic extends Product {
    private int warranty;

    public Electronic(String id, String name, int warranty) {
        super(id, name);
        this.warranty = warranty;
    }
    public String getDetails() {
        return warranty + " tháng bảo hành";
    }
}

class Kho<T extends Product> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void printInventory() {
        for (T item : items) {
            System.out.println(item.getName() + " - " + item.getDetails());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Kho<Food> foodWh = new Kho<>();
        Kho<Electronic> elecWh = new Kho<>();

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("F")) {
                String date = sc.next();
                foodWh.add(new Food(id, name, date));
            } else if (type.equals("E")) {
                int months = sc.nextInt();
                elecWh.add(new Electronic(id, name, months));
            }
        }

        System.out.println("\nKho Thực phẩm:");
        foodWh.printInventory();

        System.out.println("\nKho Điện tử:");
        elecWh.printInventory();

        sc.close();
    }
}
