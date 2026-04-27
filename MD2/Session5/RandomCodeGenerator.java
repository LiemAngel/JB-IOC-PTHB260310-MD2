package MD2.Session5;
import java.util.Random;
import java.util.Scanner;

public class RandomCodeGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // 1. Nhập n từ người dùng
        System.out.print("Nhập độ dài n của chuỗi (1 <= n <= 1000): ");
        int n = sc.nextInt();

        // Kiểm tra điều kiện n
        if (n < 1 || n > 1000) {
            System.out.println("Độ dài n không hợp lệ!");
            return;
        }

        // 2. Định nghĩa tập hợp các ký tự cho phép
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // 3. Sử dụng StringBuilder để xây dựng chuỗi hiệu quả
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // Lấy một chỉ số ngẫu nhiên từ 0 đến độ dài của chuỗi characters - 1
            int randomIndex = random.nextInt(characters.length());
            
            // Lấy ký tự tại vị trí đó và thêm vào StringBuilder
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        // 4. Xuất kết quả
        String result = sb.toString();
        System.out.println("Chuỗi ngẫu nhiên được tạo ra là:");
        System.out.println(result);
        System.out.println("Độ dài thực tế: " + result.length());
        
        sc.close();
    }
}