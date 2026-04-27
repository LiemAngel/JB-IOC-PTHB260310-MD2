package MD2.Session4;

import java.util.Scanner;

public class SelectionSortAndSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Khởi tạo mảng
        System.out.print("Nhập kích thước mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // 2. Sắp xếp chọn (Selection Sort) - Giảm dần
        selectionSortDescending(arr);

        // Hiển thị mảng đã sắp xếp
        System.out.println("\nMảng sau khi sắp xếp giảm dần:");
        displayArray(arr);

        // 3. Tìm kiếm
        System.out.print("\nNhập số cần tìm: ");
        int target = scanner.nextInt();

        // Tìm kiếm tuyến tính
        int linearResult = linearSearch(arr, target);
        System.out.println("Kết quả Tìm kiếm tuyến tính: " + 
            (linearResult != -1 ? "Tìm thấy tại vị trí " + linearResult : "Không tìm thấy"));

        // Tìm kiếm nhị phân (trên mảng giảm dần)
        int binaryResult = binarySearchDescending(arr, target);
        System.out.println("Kết quả Tìm kiếm nhị phân: " + 
            (binaryResult != -1 ? "Tìm thấy tại vị trí " + binaryResult : "Không tìm thấy"));

        scanner.close();
    }

    // Thuật toán Sắp xếp chọn - Giảm dần
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Tráo đổi phần tử lớn nhất tìm được với phần tử ở vị trí i
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Thuật toán Tìm kiếm tuyến tính
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Thuật toán Tìm kiếm nhị phân - Áp dụng cho mảng GIẢM DẦN
    public static int binarySearchDescending(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            // Vì mảng giảm dần: 
            // Nếu target lớn hơn mid, nó nằm bên trái
            if (arr[mid] < target) {
                right = mid - 1;
            } 
            // Nếu target nhỏ hơn mid, nó nằm bên phải
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void displayArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}