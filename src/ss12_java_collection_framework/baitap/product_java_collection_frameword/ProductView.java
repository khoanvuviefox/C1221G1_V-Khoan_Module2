package ss12_java_collection_framework.baitap.product_java_collection_frameword;

import java.util.Scanner;

public class ProductView {
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();

    private void menu() {
        System.out.println("Welcome to menu");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa thông tin sản phẩm theo id");
        System.out.println("3. Xoá sản phẩm theo id");
        System.out.println("4. Hiển thị danh sách sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
        System.out.println("7. Thoat");
        System.out.print("Lua chon chuc nang theo so:");
    }

    public void view() {
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    add();
                    break;
                case "2":
                    productService.update();
                    productService.show();
                    break;
                case "3":
                    break;
                case "4":
                    productService.show();
                    break;
                case "5":
                    productService.findByName();
                    break;
                case "6":
                    productService.sort();
                    productService.show();
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong dung chuc nang!");
            }
        }
    }

    public void add() {
        do {
            System.out.println("enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (productService.exist(id)) {
                System.out.println("San pham co id" + id + "da ton tai");
                return;
            }
            System.out.println("enter name: ");
            String name = scanner.nextLine();
            System.out.println("enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Product product = new Product(id, name, price, quantity);
            productService.add(product);
            System.out.println(product);
            System.out.println("Nhấn 'y' để sản phẩm mới \t|\t 'q' để quay lại \t|\t 't' để thoát");
            System.out.print(" ⭆ ");
            String option = scanner.nextLine();
            switch (option) {
                case "q":
                    return;
                case "t":
                    System.exit(0);
            }
        } while (true);
    }
}
