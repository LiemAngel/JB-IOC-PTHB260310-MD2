package MD2.Session2;

import java.util.Scanner;

public class TinhTongTu1DenN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Nhập số nguyên dương N từ bàn phím
        System.out.print("Nhập vào một số nguyên dương N: ");
        int n = input.nextInt();

        // 2. Kiểm tra tính hợp lệ của N (N phải > 0)
        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int tong = 0;

            // 3. Sử dụng vòng lặp for để cộng dồn từ 1 đến N
            for (int i = 1; i <= n; i++) {
                tong += i; // Tương đương với tong = tong + i
            }

            // 4. Hiển thị kết quả
            System.out.println("Tổng các số từ 1 đến " + n + " là: " + tong);
        }

        input.close();
    }
}