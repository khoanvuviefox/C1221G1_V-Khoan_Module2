package casestudy_module2.views;

import casestudy_module2.function.DrinkService;
import casestudy_module2.function.IDrinkService;
import casestudy_module2.items.Drink;

import java.text.DecimalFormat;
import java.util.*;

public class DrinkView {
    DecimalFormat format = new DecimalFormat("###,###.###" + " vnđ");
    public static ArrayList<Drink> drinks = new ArrayList<>();
    private final IDrinkService drinkService;
    private final Scanner scanner;

    public DrinkView() {
        drinkService = new DrinkService();
        scanner = new Scanner(System.in);
    }

    public static void menuDrinks() {
        System.out.println();
        System.out.println("\t\t\t\t|--------- Menu Manager Cafe ---------|");
        System.out.println("\t\t\t\t|   1. Hiển thị danh sách thức uống   |");
        System.out.println("\t\t\t\t|   2. Thêm món mới                   |");
        System.out.println("\t\t\t\t|   3. Sửa món                        |");
        System.out.println("\t\t\t\t|   4. Xóa món                        |");
        System.out.println("\t\t\t\t|   5. Tìm kiếm tên món               |");
        System.out.println("\t\t\t\t|   6. Quay lại Menu chính            |");
        System.out.println("\t\t\t\t|-------------------------------------|");
    }

    public void optionMenuDrink() {
        do {
            menuDrinks();
            try {
                System.out.println("\t\t\t\tChọn chức năng: ");
                System.out.print("\t\t\t\t⭆ ");
                int number = Integer.parseInt(scanner.nextLine().trim());
                switch (number) {
                    case 1:
                        showDrink();
                        break;
                    case 2:
                        addDrink();
                        break;
                    case 3:
                        updateDrink();
                        break;
                    case 4:
                        remove();
                        break;
                    case 5:
//                        findByDrinkType();
                        findByName();
//                        searchDrink();
                        break;
                    case 6:
                        Menu.select(Menu.userLogin);
                        break;
                    default:
                        System.out.println("\t\t\t\t❌ Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuDrinks();
                }
            } catch (InputMismatchException io) {
                System.out.println("\t\t\t\t❌ Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("\t\t\t\t❌ Nhập số nhé mọi người!!");
            }
        } while (true);
    }

    public void addDrink() {
        drinkService.getDrinks();
        int id;
        while (true) {
            System.out.println("\t\t\t\tNhập ID thức uống: ");
            System.out.print("\t\t\t\t\t➺ ");
            Scanner input = new Scanner(System.in);
            try {
                id = Integer.parseInt(input.nextLine());
                while (drinkService.checkDuplicateId(id)) {
                    System.out.println("\t\t\t\tID" + id + "của bạn đã tồn tại! vui lòng kiểm tra lại!!");
                    System.out.print("\t\t\t\t\t➺ ");
                    id = Integer.parseInt(scanner.nextLine());
                }
                if (id > 0) break;
                else System.out.println("\t\t\t\t❌ ID không nên nhập số âm");
            } catch (Exception e) {
                System.out.println("\t\t\t\tNhập ID là số!! ❌ Không nhập chữ nhé");
            }
        }
        String id;
        System.out.println("\t\t\t\tNhập ID thức uống (viết tắt chữ cái đầu và ghi hoa): ");
        System.out.print("\t\t\t\t\t➺ ");
        id = scanner.nextLine();
        while (drinkService.checkDuplicateId(id)) {
            System.out.println("\t\t\t\tID" + id + "của bạn đã tồn tại! vui lòng nhập lại!");
            System.out.print("\t\t\t\t\t➺ ");
            id = scanner.nextLine();
        }
        System.out.println("\t\t\t\tNhấn phím bất kì để tiếp tục và 0 để hủy thao tác");
        String cancel = scanner.nextLine();
        if (cancel.equals("0")) return;

        String drinkName = null;
        double price = 0;
        String drinkId = null;
        Drink drink = new Drink(drinkId, drinkName, price);
        setDrinkType(drink);

//        String drinkName;
        System.out.println("\t\t\t\tNhập tên món: ");
        System.out.print("\t\t\t\t\t➺ ");
        drinkName = scanner.nextLine().trim();
        while (drinkService.checkDuplicateName(drinkName)) {
            System.out.println("\t\t\t\t❌ Trùng tên món! Nhập lại nào: ");
            System.out.print("\t\t\t\t\t➺ ");
            drinkName = scanner.nextLine().trim();
        }

//        double price;
        while (true) {
            System.out.println("\t\t\t\tNhập giá thức uống: ");
            System.out.print("\t\t\t\t\t➺ ");
            try {
                price = Double.parseDouble(scanner.nextLine().trim());
                if (price > 0) {
                    break;
                }
                System.out.println("\t\t\t\t\t❌ Giá phải lớn hơn 0");
                System.out.println();
            } catch (Exception e) {
                System.out.println("\t\t\t\t\t❌ Giá phải là số");
                System.out.println();
            }
        }

        String drinkNameConvert = ConvertUtils.removeAccent(drinkName);
        char[] convert = drinkNameConvert.toCharArray();
        drinkId = String.valueOf(convert[0]);
        for (int i = 0; i < convert.length; i++) {
            if (Character.isSpaceChar(convert[i])) {
                drinkId = drinkId + convert[i + 1];
            }
        }
        if (drink.getDrinkType() == DrinkType.CAFE)
            drinkId = drinkId + "01CF";
        if (drink.getDrinkType() == DrinkType.TEA)
            drinkId = drinkId + "02TEA";
        if (drink.getDrinkType() == DrinkType.YOGURT)
            drinkId = drinkId + "03YG";
        if (drink.getDrinkType() == DrinkType.JUICE)
            drinkId = drinkId + "04JC";
        if (drink.getDrinkType() == DrinkType.SMOOTHIE)
            drinkId = drinkId + "05SMT";
        if (drink.getDrinkType() == DrinkType.OTHER)
            drinkId = drinkId + "06OT";

//        Drink drink = new Drink(drinkId.toUpperCase(), drinkName, price);
//        setDrinkType(drink);
        drink.setDrinkId(drinkId.toUpperCase());
        drink.setDrinkName(drinkName);
        drink.setPrice(price);
        drinkService.add(drink);

        System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", "ID", "Tên món", "Giá món");
        System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", drink.getDrinkId(), drink.getDrinkName(), format.format(drink.getPrice()));
        System.out.println("\t\t\t\tĐã thêm vào thành công!!");

        boolean is = true;
        do {
            System.out.println("\t\t\t\t|----------------------------------------------|");
            System.out.println("\t\t\t\t|   Nhấn 'm'(enter more) để tiếp tục thêm món  |");
            System.out.println("\t\t\t\t|        'b'(back) để quay lại Manager Cafe    |");
            System.out.println("\t\t\t\t|----------------------------------------------|");
            System.out.print("\t\t\t\t\t➺ ");
            String option = scanner.nextLine().trim();
            switch (option) {
                case "m":
                    addDrink();
                    return;
                case "b":
                    return;
                default:
                    System.out.println("\t\t\t\t❌ Vui lòng chọn lại các kí tự như trên");
                    is = false;
            }
        } while (!is);
    }

    public void setDrinkType(Drink drink) {
        System.out.println("\t\t\t\t|----Chọn chức năng----|");
        System.out.println("\t\t\t\t|      1. CAFE         |");
        System.out.println("\t\t\t\t|      2. TEA          |");
        System.out.println("\t\t\t\t|      3. YOGURT       |");
        System.out.println("\t\t\t\t|      4. JUICE        |");
        System.out.println("\t\t\t\t|      5. SMOOTHIE     |");
        System.out.println("\t\t\t\t|      6. OTHER        |");
        System.out.println("\t\t\t\t|----------------------|");
        System.out.print("\t\t\t\t\t➺ ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                drink.setDrinkType(DrinkType.CAFE);
                break;
            case 2:
                drink.setDrinkType(DrinkType.TEA);
                break;
            case 3:
                drink.setDrinkType(DrinkType.YOGURT);
                break;
            case 4:
                drink.setDrinkType(DrinkType.JUICE);
                break;
            case 5:
                drink.setDrinkType(DrinkType.SMOOTHIE);
                break;
            case 6:
                drink.setDrinkType(DrinkType.OTHER);
                break;
            default:
                System.out.println("\t\t\t\t❌ Nhập không đúng!! Chọn một số 1 đến 6");
                setDrinkType(drink);
                break;
        }
    }

    public void show() {
        List<Drink> drinks = drinkService.getDrinks();
        drinks.sort(new SortIdASC());
        System.out.println("\t\t\t\t|----------------- Menu Thức uống ----------------------|");
        System.out.printf("\t\t\t\t|%-13s %-25s %-15s|\n", "Id", "Tên món", "Giá tiền");
        for (Drink drink : drinks) {
            System.out.printf("\t\t\t\t|%-13s %-25s %-15s|\n", drink.getDrinkId(), drink.getDrinkName(), format.format(drink.getPrice()));
        }
        System.out.println("\t\t\t\t|-------------------------------------------------------|");
    }

    public void showDrink() {
        show();
        boolean is = true;
        do {
            System.out.println("\t\t\t\t|-------------------------------------|");
            System.out.println("\t\t\t\t|  Nhấn 'b' để trở lại Manager Cafe   |");
            System.out.println("\t\t\t\t|       'e' để thoát chương trình     |");
            System.out.println("\t\t\t\t|-------------------------------------|");
            System.out.print("\t\t\t\t\t➺ ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "b":
                    optionMenuDrink();
                    break;
                case "e":
                    Menu.exit();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t\t\t\t❌ Vui lòng chọn lại các kí tự như trên");
                    is = false;
            }
        } while (!is);
    }

    public void updateDrink() {
        show();
        drinkService.getDrinks();
        String id;
        System.out.println("\t\t\t\tNhập ID của món bạn cần sửa: ");
        System.out.print("\t\t\t\t\t➺ ");
        id = scanner.nextLine().trim();
        while (!drinkService.checkDuplicateId(id)) {
            System.out.println("\t\t\t\t❌ ID " + id + " này không tồn tại! vui lòng kiểm tra lại!!");
            System.out.print("\t\t\t\t\t➺ ");
            id = scanner.nextLine().trim();
        }

        System.out.println("\t\t\t\tNhấn phím bất kì để tiếp tục và 0 để hủy thao tác");
        String cancel = scanner.nextLine();
        if (cancel.equals("0")) return;

        Drink drink = drinkService.getDrinkById(id);
        boolean check = true;
        do {
            if (drinkService.exist(id)) {
                System.out.println("\t\t\t\t|------------ SỬA ------------|");
                System.out.println("\t\t\t\t|   1. Sửa tên Thức uống      |");
                System.out.println("\t\t\t\t|   2. Sửa giá Thức uống      |");
                System.out.println("\t\t\t\t|   3. Quay lại User Manager  |");
                System.out.println("\t\t\t\t|-----------------------------|");
                System.out.println("\t\t\t\tChọn chức năng");
                System.out.print("\t\t\t\t\t➺ ");
                try {
                    int choice = Integer.parseInt(scanner.nextLine().trim());
                    switch (choice) {
                        case 1:
                            System.out.println("\t\t\t\tNhập tên cần sửa: ");
                            System.out.print("\t\t\t\t\t➺ ");
                            String nameEdit = scanner.nextLine().trim();
                            while (drinkService.checkDuplicateName(nameEdit)) {
                                System.out.println("\t\t\t\t❌ Tên thức uống bị trùng, vui lòng chọn tên khác!");
                                System.out.print("\t\t\t\t\t➺ ");
                                nameEdit = scanner.nextLine().trim();
                            }
                            String drinkNameConvert = ConvertUtils.removeAccent(nameEdit);
                            char[] convert = drinkNameConvert.toCharArray();
                            String drinkId = String.valueOf(convert[0]);
                            for (int i = 0; i < convert.length; i++) {
                                if (Character.isSpaceChar(convert[i])) {
                                    drinkId = drinkId + convert[i + 1];
                                }
                            }
                            if (drink.getDrinkType() == DrinkType.CAFE)
                                drinkId = drinkId + "01CF";
                            if (drink.getDrinkType() == DrinkType.TEA)
                                drinkId = drinkId + "02TEA";
                            if (drink.getDrinkType() == DrinkType.YOGURT)
                                drinkId = drinkId + "03YG";
                            if (drink.getDrinkType() == DrinkType.JUICE)
                                drinkId = drinkId + "04JC";
                            if (drink.getDrinkType() == DrinkType.SMOOTHIE)
                                drinkId = drinkId + "05SMT";
                            if (drink.getDrinkType() == DrinkType.OTHER)
                                drinkId = drinkId + "06OT";

                            drink.setDrinkId(drinkId.toUpperCase());
                            drink.setDrinkName(nameEdit);
                            drinkService.update();
                            System.out.println("\t\t\t\tBạn đã sửa tên thức uống thành: " + drink.getDrinkName());
                            break;
                        case 2:
                            long price;
                            while (true) {
                                System.out.println("\t\t\t\tNhập giá cần sửa: ");
                                System.out.print("\t\t\t\t\t➺ ");
                                try {
                                    price = Long.parseLong(scanner.nextLine().trim());
                                    if (price > 0)
                                        break;
                                    else {
                                        System.out.println("\t\t\t\t\t❌ Giá phải lớn hơn 0");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\t\t\t\t\t❌ Giá phải là số");
                                }
                            }
                            drink.setPrice(price);
                            drinkService.update();
                            System.out.println("\t\t\t\tBạn đã sửa giá thức uống thành: " + format.format(drink.getPrice()));
                            break;
                        case 3:
                            optionMenuDrink();
                            break;
                        default:
                            System.out.println("\t\t\t\t❌ Vui lòng chọn số theo chức năng bên dưới!!");
                            updateDrink();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("\t\t\t\t❌ Vui lòng nhập số theo chức năng!!");
                }

                boolean is = true;
                do {
                    System.out.println("\t\t\t\t|---------------------------------------------------|");
                    System.out.println("\t\t\t\t|   Nhấn 'm'(more) để sửa thông tin khác            |");
                    System.out.println("\t\t\t\t|        'y' nếu muốn xem tất cả thông tin vừa sửa  |");
                    System.out.println("\t\t\t\t|        'd'(different) để sửa món khác             |");
                    System.out.println("\t\t\t\t|        'b'(back) để quay lại User Manager         |");
                    System.out.println("\t\t\t\t|---------------------------------------------------|");
                    System.out.print("\t\t\t\t\t➺ ");
                    String choice1 = scanner.nextLine().trim();
                    switch (choice1) {
                        case "m":
                            check = false;
                            break;
                        case "y":
                            System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", "ID", "Tên món", "Giá món");
                            System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", drink.getDrinkId(), drink.getDrinkName(), format.format(drink.getPrice()));
                            break;
                        case "d":
                            drinkService.update();
                            updateDrink();
                            break;
                        case "b":
                            return;
                        default:
                            System.out.println("\t\t\t\t❌ Vui lòng chọn lại các kí tự như trên");
                            is = false;
                    }
                } while (!is);
            }
        } while (!check);
    }

    public void remove() {
        show();
        System.out.println("\t\t\t\tNhấn phím bất kì để tiếp tục và 0 để hủy thao tác");
        String cancel = scanner.nextLine();
        if (cancel.equals("0")) return;

        drinkService.getDrinks();
        System.out.println("\t\t\t\tnhập ID bạn cần xóa: ");
        System.out.print("\t\t\t\t\t➺ ");
        String id = scanner.nextLine().trim();
        Drink drink = drinkService.getDrinkById(id);
        if (drink == null) {
            System.out.println("\t\t\t\t❌ Món này không tồn tại!! ");
        } else {
            drinkService.remove(drink);
            System.out.println("\t\t\t\t❌ Đã xóa thành công!!");
        }
        optionMenuDrink();
    }

    public void findByName() {
        System.out.println("\t\t\t\tNhập tên sản phẩm: ");
        String searchName = scanner.nextLine().trim();
        List<Drink> drinks = drinkService.getDrinks();
        boolean found = false;
        System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", "ID", "Tên món", "Giá món");
        for (Drink drink : drinks) {
            if (drink.getDrinkName().trim().toLowerCase().contains(searchName.toLowerCase().trim())) {
                System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", drink.getDrinkId(), drink.getDrinkName(), format.format(drink.getPrice()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t❌ Không tìm thấy " + searchName);
        }
    }

    public void findByDrinkType() {
        System.out.println("\t\t\t\tNhập loại thức uống bạn cần tìm: ");
        String searchType = scanner.nextLine().trim();
        List<Drink> drinks = drinkService.getDrinks();
        boolean found = true;
        System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", "ID", "Tên món", "Giá món");
        for (Drink drink : drinks) {
            if (String.valueOf(drink.getDrinkType()).equals(searchType.toUpperCase())) {
                System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", drink.getDrinkId(), drink.getDrinkName(), format.format(drink.getPrice()));
                found = false;
            }
        }
        if (!found)
            System.out.println("\t\t\t\t❌ Không có loại thức uống " + searchType);
    }

    public void searchDrink() {
        System.out.println("\t\t\t\tNhập tên hoặc loại thức uống: ");
        System.out.print("\t\t\t\t\t➺ ");
        String search = scanner.nextLine().trim();
        List<Drink> drinks = drinkService.getDrinks();
        boolean found = true;
        System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", "ID", "Tên món", "Giá món");
        for (Drink drink : drinks) {
            if (String.valueOf(drink.getDrinkType()).equals(search.toUpperCase()) || drink.getDrinkName().trim().toLowerCase().contains(search.toLowerCase().trim())) {
                System.out.printf("\t\t\t\t|%-15s %-20s %-20s |\n", drink.getDrinkId(), drink.getDrinkName(), format.format(drink.getPrice()));
                found = false;
            }
//            else {
//               if (drink.getDrinkName().trim().toLowerCase().contains(search.toLowerCase().trim()))
//                {
//                    System.out.println(drink);
//                    found = false;
//                }
//            }
        }
        if (!found)
            System.out.println("\t\t\t\t❌ Không có loại thức uống " + search);
    }

}
