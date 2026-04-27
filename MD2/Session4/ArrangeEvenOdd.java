package MD2.Session4;

import java.util.Scanner;

public class ArrangeEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập số lượng phần tử
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();

        // Kiểm tra mảng không hợp lệ
        if (n <= 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        // 2. Nhập các giá trị của mảng
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 3. Xử lý sắp xếp (Giữ nguyên thứ tự trong từng nhóm)
        int[] result = new int[n];
        int index = 0;

        // Bước 3.1: Duyệt qua mảng để lấy các số chẵn trước
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }

        // Bước 3.2: Duyệt qua mảng một lần nữa để lấy các số lẻ
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }

        // 4. In kết quả
        System.out.println("Mảng sau khi sắp xếp (chẵn trước, lẻ sau):");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}