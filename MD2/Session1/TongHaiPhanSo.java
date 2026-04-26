import java.util.Scanner;
public class TongHaiPhanSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập phân số thứ nhất (a/b)
        System.out.println("Nhập phân số thứ nhất:");
        System.out.print("Tử số (a): ");
        int a = scanner.nextInt();
        System.out.print("Mẫu số (b): ");
        int b = scanner.nextInt();

        // 2. Nhập phân số thứ hai (c/d)
        System.out.println("\nNhập phân số thứ hai:");
        System.out.print("Tử số (c): ");
        int c = scanner.nextInt();
        System.out.print("Mẫu số (d): ");
        int d = scanner.nextInt();

        // Kiểm tra mẫu số khác 0
        if (b == 0 || d == 0) {
            System.out.println("Lỗi: Mẫu số phải khác 0!");
        } else {
            // 3. Tính tổng theo công thức: (ad + bc) / (bd)
            int tuSoTong = a * d + b * c;
            int mauSoTong = b * d;

            // 4. In kết quả ra màn hình dưới dạng a/b
            System.out.println("\n--- Kết quả ---");
            System.out.printf("Tổng hai phân số là: %d/%d\n", tuSoTong, mauSoTong);
        }

        scanner.close();
    }
}
