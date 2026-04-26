package MD2.Session2;

import java.util.Scanner;

public class KiemTraTamGiac {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập ba số nguyên dương tương ứng với ba cạnh tam giác
        System.out.println("Nhập vào ba cạnh của tam giác:");
        System.out.print("Cạnh thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Cạnh thứ hai: ");
        int b = scanner.nextInt();
        System.out.print("Cạnh thứ ba: ");
        int c = scanner.nextInt();

        // 2. Kiểm tra xem ba cạnh có tạo thành một tam giác hợp lệ không
        // Quy tắc: Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại
        if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
            
            // 3. Nếu hợp lệ, tiến hành phân loại
            System.out.print("Kết quả: ");
            
            if (a == b && b == c) {
                // Tam giác đều: Ba cạnh bằng nhau
                System.out.println("Tam giác đều");
            } else if (a == b || b == c || a == c) {
                // Tam giác cân: Hai cạnh bằng nhau
                System.out.println("Tam giác cân");
            } else if (isVuong(a, b, c)) {
                // Tam giác vuông: Bình phương một cạnh bằng tổng bình phương hai cạnh còn lại
                System.out.println("Tam giác vuông");
            } else {
                // Tam giác thường: Không thuộc các loại trên
                System.out.println("Tam giác thường");
            }
            
        } else {
            // Hiển thị thông báo nếu không tạo thành tam giác hợp lệ
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        scanner.close();
    }

    public static boolean isVuong(int a, int b, int c) {
        return (a * a == b * b + c * c) || 
               (b * b == a * a + c * c) || 
               (c * c == a * a + b * b);
    }
}
