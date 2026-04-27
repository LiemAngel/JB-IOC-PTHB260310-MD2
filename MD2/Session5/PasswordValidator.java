package MD2.Session5;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập mật khẩu từ người dùng
        System.out.print("Nhập vào mật khẩu cần kiểm tra: ");
        String password = scanner.nextLine();
        
        // Định nghĩa Regex cho mật khẩu hợp lệ
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$";
        
        // Kiểm tra tính hợp lệ bằng phương thức matches()
        if (password.matches(regex)) {
            System.out.println("Mật khẩu hợp lệ"); //
        } else {
            System.out.println("Mật khẩu không hợp lệ"); //
        }
        
        scanner.close();
    }
}