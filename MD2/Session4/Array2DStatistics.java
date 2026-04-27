package MD2.Session4;

import java.util.Scanner;

public class Array2DStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập kích thước mảng 2 chiều
        System.out.print("Nhập số hàng: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        // 2. Nhập từng giá trị cho mảng
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Nhập phần tử [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 3. Tính tổng số chẵn và số lẻ
        long sumEven = 0;
        long sumOdd = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] % 2 == 0) {
                    sumEven += matrix[i][j];
                } else {
                    sumOdd += matrix[i][j];
                }
            }
        }

        // 4. Hiển thị kết quả
        System.out.println("\n--- Kết quả ---");
        System.out.println("Tổng các số chẵn: " + sumEven);
        System.out.println("Tổng các số lẻ: " + sumOdd);

        scanner.close();
    }
}