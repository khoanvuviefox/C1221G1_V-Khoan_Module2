package casestudy_module2.views;

import casestudy_module2.function.IMemberService;
import casestudy_module2.function.MemberService;
import casestudy_module2.items.Member;
import casestudy_module2.ulits.ConvertUtils;
import casestudy_module2.ulits.ValidateUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static jdk.jfr.internal.instrument.JDKEvents.remove;

public class MemberView {
    public static List<Member> members = new ArrayList<>();
    private final IMemberService memberService;
    private final Scanner scanner;

    public MemberView() {
        memberService = new MemberService();
        scanner = new Scanner(System.in);
    }

    public static void menuMember() {
        System.out.println("\t\t\t\t|---------- Member Manager ------------|");
        System.out.println("\t\t\t\t|   1. Thêm nhân viên mới             |");
        System.out.println("\t\t\t\t|   2. Hiển thị danh sách nhân viên   |");
        System.out.println("\t\t\t\t|   3. Sửa thông tin nhân viên        |");
        System.out.println("\t\t\t\t|   4. Xóa nhân viên khỏi danh sách   |");
        System.out.println("\t\t\t\t|   5. Quay lại Menu chính            |");
        System.out.println("\t\t\t\t|-------------------------------------|");
    }

    public void optionMenuMember() {
        do {
            menuMember();
            try {
                System.out.println("\t\t\t\tChọn chức năng: ");
                System.out.print("\t\t\t\t⭆ ");
                int number = Integer.parseInt(scanner.nextLine().trim());
                switch (number) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        showMemberList();
                        break;
                    case 3:
                        updateMember();
                        break;
                    case 4:
                        remove();
                        break;
                    case 5:
                        Menu.select(Menu.userLogin);
                        break;
                    default:
                        System.out.println("\t\t\t\t❌ Chọn chức năng không đúng!! Mời chọn lại!");
                        menuMember();
                }
            } catch (InputMismatchException io) {
                System.out.println("\t\t\t\t❌ Nhập sai rồi!! Nhập lại nào!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("\t\t\t\t❌ Nhập số nhé mọi người!!");
            }
        } while (true);
    }

    private void showMemberList() {
    }

    public void addMember() {
        System.out.println("\t\t\t\tNhấn phím bất kì để tiếp tục và 0 để hủy thao tác");
        String cancel = scanner.nextLine();
        if (cancel.equals("0")) return;

        int id;
        while (true) {
            System.out.println("\t\t\t\tTạo ID cho nhân viên nào: ");
            System.out.print("\t\t\t\t\t➺ ");
            try {
                id = Integer.parseInt(scanner.nextLine().trim());
                if (id > 0) break;
                System.out.println("\t\t\t\t❌ Nhập ID sai rồi, nhập số lớn hơn 0!");
            } catch (Exception e) {
                System.out.println("\t\t\t\t❌ Nhập ID sai rồi, nhập số đi ạ!");
            }
        }

        System.out.println("\t\t\t\tNhập họ và tên lưu ý viết hoa chữ cái đầu!!");
        System.out.print("\t\t\t\t\t➺ ");
        String memberName;
        String nameConvert;
//        boolean checkName = true;
//        do {
        memberName = scanner.nextLine().trim();
        nameConvert = ConvertUtils.removeAccent(memberName);
        while (memberService.checkDuplicateMemberName(memberName.trim())) {
            System.out.println("\t\t\t\t❌ Họ tên đã tồn tại");
            System.out.print("\t\t\t\t\t➺ ");
            memberName = scanner.nextLine().trim();

        }
        while (!ValidateUtils.isNameValid(nameConvert.trim())) {
            System.out.println("\t\t\t\t❌ Nhập sai rồi! lưu ý viết hoa chữ cái đầu!!");
            System.out.print("\t\t\t\t\t➺ ");
            memberName = scanner.nextLine().trim();


            System.out.println("\t\t\t\tNhập số điện thoại và đủ 10 số và bắt đầu là số 0");
            System.out.print("\t\t\t\t\t➺ ");
            String phoneNumber;
//        boolean checkPhone = true;
//        do {
            phoneNumber = scanner.nextLine().trim();
            while (memberService.checkDuplicatePhone(phoneNumber)) {
                System.out.println("\t\t\t\t❌ Số điện thoại này đã tồn tại! vui lòng kiểm tra lại!");
                System.out.print("\t\t\t\t\t➺ ");
                phoneNumber = scanner.nextLine().trim();
//                    checkPhone = false;
            }

            while (!ValidateUtils.isPhoneValid(phoneNumber)) {
                System.out.println("\t\t\t\t❌ Số điện thoại bao gồm 10 số và bắt đầu là số 0");
                System.out.print("\t\t\t\t\t➺ ");
                phoneNumber = scanner.nextLine().trim();


                System.out.println("\t\t\t\tNhập email: ");
                System.out.print("\t\t\t\t\t➺ ");
                String email;

                email = scanner.nextLine().trim();
                while (!ValidateUtils.isEmailValid(email)) {
                    System.out.println("\t\t\t\t❌ Email của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                    System.out.println("\t\t\t\tVí dụ: abcd@gmail.com");
                    System.out.print("\t\t\t\t\t➺ ");
                    String emailfalse = scanner.nextLine().trim();

                }

                while (memberService.checkDuplicateEmail(email)) {
                    System.out.println("\t\t\t\t❌ Email " + email + " của bạn đã tồn tại! vui lòng kiểm tra lại");
                    System.out.print("\t\t\t\t\t➺ ");
                    email = scanner.nextLine().trim();

                }
//            }
//        } while (!checkEmail);

                System.out.println("\t\t\t\tNhập địa chỉ:");
                System.out.print("\t\t\t\t\t➺ ");
                String address = scanner.nextLine().trim();
                System.out.println("\t\t\t\tNhập chức vụ nhân viên nào: ");
                System.out.print("\t\t\t\t\t➺ ");
                String department = scanner.nextLine().trim();
                Member member = new Member(id, memberName, phoneNumber, email, address, department);
                memberService.add(member);
                boolean check = true;
                do {
                    System.out.println("\t\t\t\t|----------------------------------------------|");
                    System.out.println("\t\t\t\t|   Nhấn 'm'(more) để thêm tiếp người dùng     |");
                    System.out.println("\t\t\t\t|        'b'(back) để quay lại User Manager    |");
                    System.out.println("\t\t\t\t|----------------------------------------------|");
                    System.out.println("\t\t\t\t\t➺ ");
                    String choice = scanner.nextLine().trim();
                    switch (choice) {
                        case "m":
                            addMember();
                            break;
                        case "b":
                            return;
                        default:
                            System.out.println("\t\t\t\t❌ Chọn 'm' hoặc 'b' để thực hiện chức năng!!");
                            check = false;
                    }
                } while (!check);
            }

            public void showMember() {
                System.out.println("\t\t\t\t|--------------------------------------------------------------------------------------|");
                System.out.printf("\t\t\t\t|%-10s %-25s %-15s %-20s %-20s %-12s|\n", "ID", "Họ và Tên", "Số điện thoại", "Email", "Địa chỉ", "Chức vụ");
                List<Member> members = memberService.getMember();
                for (Member member : members) {
                    System.out.printf("\t\t\t\t|%-10s %-25s %-15s %-20s %-20s %-12s|\n", member.getMember_id(), member.getMember_name(), member.getPhone_number(), member.getEmail(), member.getAddress(), member.getDepartment());
                }
                System.out.println("\t\t\t\t|--------------------------------------------------------------------------------------|");
            }

            public void showMemberList() {
                List<Member> members = memberService.getMember();
                try {
                    showMember();
                    boolean is = true;
                    do {
                        System.out.println("\t\t\t\t|-------------------------------------------|");
                        System.out.println("\t\t\t\t|  Nhấn 'b'(back) để quay lại User Manager  |");
                        System.out.println("\t\t\t\t|       'e'(exit) để thoát chương trình     |");
                        System.out.println("\t\t\t\t|-------------------------------------------|");
                        System.out.println("\t\t\t\t\t➺ ");
                        String choice = scanner.nextLine().trim();
                        switch (choice) {
                            case "b":
                                return;
                            case "e":
                                Menu.exit();
                                System.exit(0);
                                break;
                            default:
                                System.out.println("\t\t\t\t❌ Nhấn 'b' hoặc 'e' để thực hiện chức năng");
                                is = false;
                        }
                    } while (!is);
                } catch (Exception e) {
                    System.out.println("\t\t\t\t❌ Nhập sai rồi!! Nhập lại nào!");
                }
            }

            public void updateMember() {
                System.out.println("\t\t\t\tNhấn phím bất kì để tiếp tục và 0 để hủy thao tác");
                String cancel = scanner.nextLine();
                if (cancel.equals("0")) return;

                try {
                    showMember();
                    int id;
                    while (true) {
                        System.out.println("\t\t\t\tNhập ID của người dùng bạn muốn sửa");
                        System.out.println("\t\t\t\t\t➺ ");
                        try {
                            id = Integer.parseInt(scanner.nextLine().trim());
                            while (!memberService.checkDuplicateId(id)) {
                                System.out.println("\t\t\t\t❌ ID" + id + "của bạn không tồn tại! vui lòng kiểm tra lại!!");
                                System.out.println("\t\t\t\t\t➺ ");
                                id = Integer.parseInt(scanner.nextLine());
                            }
                            if (id > 0) break;
                            else System.out.println("\t\t\t\t❌ Không có ID nào là số âm");
                        } catch (Exception e) {
                            System.out.println("\t\t\t\t❌ Nhập ID là số!! Không nhập chữ nhé!");
                        }
                    }

                    boolean check = true;
                    do {
                        if (memberService.exist(id)) {
                            System.out.print("\t\t\t\t|------------ SỬA ------------|");
                            System.out.print("\t\t\t\t|   1. Sửa tên Nhân viên      |");
                            System.out.print("\t\t\t\t|   2. Sửa số điện thoại      |");
                            System.out.print("\t\t\t\t|   3. Đổi Email              |");
                            System.out.print("\t\t\t\t|   4. Sửa địa chỉ            |");
                            System.out.print("\t\t\t\t|   5. Sửa chức vụ            |");
                            System.out.print("\t\t\t\t|   6. Quay lại User Manager  |");
                            System.out.println("\t\t\t\t-----------------------------|");
                            System.out.print("\t\t\t\tChọn chức năng");
                            System.out.print("\t\t\t\t\t➺ ");
                            int choice = Integer.parseInt(scanner.nextLine().trim());
                            Member member = new Member();
                            member.setMember_id(id);
//                    boolean checkChoice = true;
//                    do {
                            switch (choice) {
                                case 1:
                                    System.out.print("\t\t\t\tNhập tên người và lưu ý viết hoa chữ cái đầu!!");
                                    System.out.print("\t\t\t\t\t➺ ");
                                    String fullNameUpdate;
                                    String namecheck;
                                    boolean checkUpdate = true;
                                    do {
                                        fullNameUpdate = scanner.nextLine().trim();
                                        namecheck = ConvertUtils.removeAccent(fullNameUpdate);
                                        if (!ValidateUtils.isNameValid(namecheck.trim())) {
                                            System.out.print("\t\t\t\t❌ Nhập sai rồi! lưu ý viết hoa chữ cái đầu!!");
                                            System.out.print("\t\t\t\t\t➺ ");
                                            checkUpdate = false;
                                        } else {
                                            if (!memberService.checkDuplicateMemberName(fullNameUpdate.trim())) {
                                                System.out.print("\t\t\t\t❌ Họ tên đã tồn tại");
                                                System.out.print("\t\t\t\t\t➺ ");
                                                checkUpdate = false;
                                            }
                                        }
                                    } while (!checkUpdate);
                                    member.setMember_name(fullNameUpdate);
                                    memberService.update(member);
                                    System.out.print("\t\t\t\tĐổi tên thành công rồi!!");
                                    break;
                                case 2:
                                    System.out.print("\t\t\t\tNhập số điện thoại muốn sửa đổi");
                                    System.out.print("\t\t\t\t\t➺ ");
                                    String phoneNumberUpdate;
                                    boolean checkPhone = true;
                                    do {
                                        phoneNumberUpdate = scanner.nextLine().trim();
                                        if (!ValidateUtils.isPhoneValid(phoneNumberUpdate)) {
                                            System.out.print("\t\t\t\t❌ Số điện thoại bao gồm 10 số và bắt đầu là số 0!! Nhập lại nào!");
                                            System.out.print("\t\t\t\t\t➺ ");
                                            checkPhone = false;
                                        } else {
                                            if (memberService.checkDuplicatePhone(phoneNumberUpdate)) {
                                                System.out.print("\t\t\t\t❌ Số điện thoại này đã tồn tại! Mời bạn nhập lại");
                                                System.out.print("\t\t\t\t\t➺ ");
                                                checkPhone = false;
                                            }
                                        }
                                    } while (!checkPhone);

                                    member.setPhone_number(phoneNumberUpdate);
                                    memberService.update(member);
                                    System.out.print("\t\t\t\tĐổi số điện thoại thành công");
                                    break;

                                case 3:
                                    System.out.print("\t\t\t\tNhập Email muốn sửa đổi: ");
                                    System.out.print("\t\t\t\t\t➺ ");
                                    String emailUpdate;
                                    boolean checkEmail = true;
                                    do {
                                        emailUpdate = scanner.nextLine().trim();
                                        if (!ValidateUtils.isEmailValid(emailUpdate)) {
                                            System.out.print("\t\t\t\t❌ Email sai rồi, nhớ nhập theo dạng abc@gmail.com(.vn)");
                                            System.out.print("\t\t\t\t\t➺ ");
                                            checkEmail = false;
                                        } else {
                                            if (memberService.checkDuplicateEmail(emailUpdate)) {
                                                System.out.print("\t\t\t\t❌ Email này đã tồn tại! Nhập cái mới đi nào!!");
                                                System.out.print("\t\t\t\t\t➺ ");
                                                checkEmail = false;
                                            }
                                        }
                                    } while (!checkEmail);

                                    member.setEmail(emailUpdate);
                                    memberService.update(member);
                                    System.out.print("\t\t\t\tĐổi Email thành công!");
                                    break;

                                case 4:
                                    System.out.print("\t\t\t\tNhập địa chỉ muốn đổi");
                                    System.out.print("\t\t\t\t\t➺ ");
                                    String address = scanner.nextLine().trim();
                                    member.setAddress(address);
                                    memberService.update(member);
                                    System.out.print("\t\t\t\tĐổi địa chỉ thành công");
                                    break;

                                case 5:
                                    System.out.print("\t\t\t\tNhập chức vụ bạn muốn sửa: ");
                                    System.out.print("\t\t\t\t\t➺ ");
                                    String department = scanner.nextLine().trim();
                                    member.setDepartment(department);
                                    memberService.update(member);
                                    System.out.print("\t\t\t\tSửa thành công");
                                    break;

                                case 6:
                                    return;
                                default:
                                    System.out.print("\t\t\t\t❌ Vui lòng chọn số theo chức năng bên dưới!!");
//                                checkChoice = false;
//                                break;
                                    updateMember();
                            }
//                    }while (!checkChoice);
                            boolean is = true;
                            do {
                                System.out.print("\t\t\t\t|--------------------------------------------|");
                                System.out.print("\t\t\t\t|   Nhấn 'm'(more) để tiếp tục sửa           |");
                                System.out.print("\t\t\t\t|        'd'(different) để sửa món khác      |");
                                System.out.print("\t\t\t\t|        'b'(back) để quay lại User Manager  |");
                                System.out.print("\t\t\t\t|--------------------------------------------|");
                                System.out.print("\t\t\t\t\t➺ ");
                                String choice1 = scanner.nextLine().trim();
                                switch (choice1) {
                                    case "m":
                                        check = false;
                                        break;
                                    case "d":
                                        updateMember();
                                        break;
                                    case "b":
                                        return;
                                    default:
                                        System.out.println("\t\t\t\t❌ Nhấn không đúng! vui lòng chọn lại");
                                        is = false;
                                }
                            } while (!is);
                        } else {
                            System.out.println("\t\t\t\t❌ Không tìm thấy ID! Vui lòng nhập lại");
                            updateMember();
                        }
                    } while (!check);
                } catch (Exception e) {
                    System.out.println("\t\t\t\t❌ Nhập sai! vui lòng nhập lại");
                }
            }

            public void remove() {
                showMember();
                System.out.println("\t\t\t\tNhấn phím bất kì để tiếp tục và 0 để hủy thao tác");
                String cancel = scanner.nextLine();
                if (cancel.equals("0")) return;

                System.out.println("\t\t\t\tNhập ID người dùng cần xóa");
                System.out.print("\t\t\t\t\t➺ ");
                int id = Integer.parseInt(scanner.nextLine().trim());
                Member member = memberService.getMemberById(id);
                if (member == null)
                    System.out.println("\t\t\t\t ❌ Mgười dùng này không tồn tại!! ");
                else {
                    memberService.remove(member);
                    System.out.println("\t\t\t\t ❌ Đã xóa thành công!! ");
                }
                optionMenuMember();
            }
        }
    }

    private void showMember() {
    }

    private void updateMember() {
    }
}