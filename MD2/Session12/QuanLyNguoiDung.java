import java.util.LinkedList;
import java.util.Scanner;

public class UserManagement {

    // Lớp Person lưu thông tin người dùng
    static class Person {
        String name;
        String email;
        String phone;

        public Person(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }
    }

    // LinkedList lưu danh sách người dùng
    static LinkedList<Person> userList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Lựa chọn của bạn: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa buffer

            switch (choice) {
                case 1 -> addUser();
                case 2 -> deleteUser();
                case 3 -> displayUsers();
                case 4 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 4);
    }

    // In menu
    static void printMenu() {
        System.out.println("\n*************** MENU QUẢN LÝ NGƯỜI DÙNG ***************");
        System.out.println("1. Thêm người dùng");
        System.out.println("2. Xóa người dùng");
        System.out.println("3. Hiển thị danh sách người dùng");
        System.out.println("4. Thoát");
    }

    // Thêm người dùng
    static void addUser() {
        String name = readNonEmpty("Nhập tên người dùng: ");
        String email = readNonEmpty("Nhập email người dùng: ");
        String phone = readNonEmpty("Nhập số điện thoại người dùng: ");

        userList.add(new Person(name, email, phone));
        System.out.println("Người dùng đã được thêm thành công.");
    }

    // Xóa người dùng theo email
    static void deleteUser() {
        String email = readNonEmpty("Nhập email người dùng để xóa: ");

        boolean removed = userList.removeIf(p -> p.email.equalsIgnoreCase(email));
        if (removed) {
            System.out.println("Người dùng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy người dùng với email: " + email);
        }
    }

    // Hiển thị danh sách người dùng
    static void displayUsers() {
        if (userList.isEmpty()) {
            System.out.println("Danh sách người dùng trống.");
            return;
        }
        System.out.println("\nDanh sách người dùng:");
        for (Person p : userList) {
            System.out.println("Tên: " + p.name
                    + ", Email: " + p.email
                    + ", Số điện thoại: " + p.phone);
        }
    }

    // Đọc chuỗi không được để trống
    static String readNonEmpty(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui lòng ko để trống !");
            }
        } while (input.isEmpty());
        return input;
    }
}