//Aim: To add products, update stock quantities, and display inventory using an Iterator.


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    HashMap<Integer, Integer> products = new HashMap<>();

    void addProduct(int id, int stock) {
        products.put(id, stock);
        System.out.println(
                "Product " + id + " added with stock " + stock
        );
    }

    void updateStock(int id, int stock) {
        if (products.containsKey(id)) {
            products.put(id, stock);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {
        Iterator<Map.Entry<Integer, Integer>> it =
                products.entrySet().iterator();

        System.out.println("Product Inventory:");

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.println(
                    "Product ID: " + entry.getKey()
                            + ", Stock: " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();
        int choice;

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();

                    inv.addProduct(id, stock);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Enter New Stock: ");
                    int newStock = sc.nextInt();

                    inv.updateStock(pid, newStock);
                    break;

                case 3:
                    inv.displayInventory();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
