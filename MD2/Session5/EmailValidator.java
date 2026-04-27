package MD2.Session5;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập chuỗi email từ bàn phím
        System.out.print("Nhập địa chỉ email cần kiểm tra: ");
        String email = sc.nextLine();

        // 2. Xử lý khoảng trắng thừa ở hai đầu (theo mô tả)
        email = email.trim();

        // 3. Định nghĩa chuỗi Regex
        // Giải thích:
        // ^[A-Za-z0-9._]+ : Bắt đầu bằng chữ, số, chấm hoặc gạch dưới (ít nhất 1 ký tự)
        // @               : Phải có ký tự @
        // [A-Za-z0-9.]+   : Domain chứa chữ, số hoặc dấu chấm
        // \.              : Dấu chấm ngăn cách với đuôi miền
        // [A-Za-z]{2,6}$  : Đuôi miền từ 2-6 ký tự chữ cái, kết thúc chuỗi
        String emailRegex = "^[A-Za-z0-9._]+@[A-Za-z0-9.]+\\.[A-Za-z]{2,6}$";

        // 4. Kiểm tra và hiển thị kết quả
        if (email.matches(emailRegex)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
        
        sc.close();
    }
}