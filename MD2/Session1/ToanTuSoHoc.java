import java.util.Scanner;
public class ToanTuSoHoc {
    public static void main(String[] args) {
        // Khởi tạo Scanner để nhập dữ liệu
        Scanner scanner = new Scanner(System.in);

        // 1. Khai báo và nhập giá trị cho hai số nguyên
        System.out.print("Nhập số thứ nhất (firstNumber): ");
        int firstNumber = scanner.nextInt();

        System.out.print("Nhập số thứ hai (secondNumber): ");
        int secondNumber = scanner.nextInt();

        // 2. Thực hiện các phép toán
        int tong = firstNumber + secondNumber;
        int hieu = firstNumber - secondNumber;
        int tich = firstNumber * secondNumber;
        
        // Lưu ý: Phép chia số nguyên trong Java sẽ lấy phần nguyên
        int thuong = 0;
        int phanDu = 0;
        
        if (secondNumber != 0) {
            thuong = firstNumber / secondNumber;
            phanDu = firstNumber % secondNumber;
        }

        // 3. In kết quả ra màn hình theo định dạng
        System.out.println("\n--- Kết quả ---");
        System.out.println("firstNumber = " + firstNumber);
        System.out.println("secondNumber = " + secondNumber);
        System.out.println("Tổng = " + tong);
        System.out.println("Hiệu = " + hieu);
        System.out.println("Tích = " + tich);
        System.out.println("Thương = " + thuong);
        System.out.println("Phần dư = " + phanDu);

        scanner.close();
}
}
