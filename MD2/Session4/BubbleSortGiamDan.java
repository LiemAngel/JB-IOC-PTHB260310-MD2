package MD2.Session4;

import java.util.Scanner;

public class BubbleSortGiamDan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Khởi tạo mảng
        System.out.print("Nhập kích thước của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // 2. Sắp xếp nổi bọt theo thứ tự giảm dần
        bubbleSortDescending(arr);

        // 3. Hiển thị mảng đã sắp xếp
        System.out.println("\nMảng sau khi sắp xếp giảm dần:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        
        scanner.close();
    }

    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Để sắp xếp giảm dần, ta kiểm tra nếu phần tử trước NHỎ HƠN phần tử sau
                if (arr[j] < arr[j + 1]) {
                    // Tráo đổi vị trí
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có lần tráo đổi nào, mảng đã được sắp xếp xong
            if (!swapped) break;
        }
    }
}