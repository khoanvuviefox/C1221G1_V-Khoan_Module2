package ss12_java_collection_framework.baitap.product_java_collection_frameword;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    public ArrayList<Product> products = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public ProductService() {
        products.add(new Product(2, "khoan", 62, 5));
        products.add(new Product(3, "vu", 74, 5));
        products.add(new Product(4, "dep", 44, 5));
        products.add(new Product(5, "trai", 43, 5));
    }

    public void add(Product product) {
        products.add(product);
    }

    public void update() {
        System.out.println("nhap id can sua: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = findById(id);
        if (product == null) {
            System.out.println("Khong co san pham nay");
            return;
        }
        System.out.println("Nhap ten can sua: ");
        String name = scanner.nextLine();
        System.out.println("Nhap gia can sua: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhap so luong can sua: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
    }

    public void show() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void findByName() {
        System.out.println("Nhap ten san pham: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("khong tim thay");
        }
    }

    public boolean exist(int id) {
        return findById(id) != null;
        //   Product product = findById(id);
//        if(product!=null)
//            return true;
//        else
//            return false;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void sort() {
        do {
            System.out.println("ban muon sap xep theo: ");
            System.out.println("1: gia giam dan");
            System.out.println("2: gia tang dan");
            System.out.println("3: thoat");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    products.sort(new PriceSortDESC());
                    return;
                case 2:
                    products.sort(new PriceSortASC());
                    return;
                default:
                    System.out.println("nhap 1 hoac 2");
                    break;
            }
            if (option == 3) break;
        }
        while (true);
    }
}
