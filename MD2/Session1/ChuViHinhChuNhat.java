import java.util.Scanner;
public class ChuViHinhChuNhat {
    public static void main(String[] args) {
        // Khởi tạo Scanner để nhập dữ liệu
        Scanner scanner = new Scanner(System.in);

        // 1. Khai báo và nhập giá trị cho chiều dài và chiều rộng
        System.out.print("Nhập chiều dài (length): ");
        int length = scanner.nextInt();

        System.out.print("Nhập chiều rộng (width): ");
        int width = scanner.nextInt();

        // 2. Tính chu vi theo công thức: P = 2 * (length + width)
        int perimeter = 2 * (length + width);

        // 3. In
        System.out.println("\n--- Kết quả ---");
        System.out.println("Chiều dài (length) = " + length);   
        System.out.println("Chiều rộng (width) = " + width);
        System.out.println("Chu vi (perimeter) = " + perimeter);

        scanner.close();
    }
}