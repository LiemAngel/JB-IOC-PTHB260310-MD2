package MD2.Session2;
import java.util.Scanner;
public class TinhTongCacChuSoNguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên N: ");
        long n = scanner.nextLong();

        // 2. Xử lý: Nếu số là âm, chuyển nó thành số dương
        long originalN = n;
        long tempN = Math.abs(n); 
        
        long tong = 0;

        // 3. Sử dụng vòng lặp để tách từng chữ số (lấy phần dư khi chia 10)
        while (tempN > 0) {
            long chuSo = tempN % 10; // Lấy chữ số cuối cùng
            tong += chuSo;           // Cộng dồn vào tổng
            tempN /= 10;             // Bỏ chữ số cuối cùng đã lấy
        }

        // 4. Đầu ra: Hiển thị kết quả
        System.out.println("Tổng các chữ số của " + originalN + " là: " + tong);

        scanner.close();
    }
}
