package MD2.Session2;

import java.util.Scanner;

public class TimSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Yêu cầu nhập một số nguyên từ 1 đến 12
        System.out.print("Nhập vào một số nguyên (1-12): ");
        int month = scanner.nextInt();

        // 2. Sử dụng cấu trúc switch-case để xử lý
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " có 30 ngày");
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày");
                break;
            default:
                // 3. Xử lý trường hợp số không hợp lệ
                System.out.println("Tháng không hợp lệ.");
                break;
        }

        scanner.close();
    }
}
