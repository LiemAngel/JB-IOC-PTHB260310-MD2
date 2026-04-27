package MD2.Session4;
import java.util.Scanner;

public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập số lượng sinh viên và điểm số ban đầu
        System.out.print("Nhập số lượng sinh viên (n): ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Số lượng sinh viên không hợp lệ!");
            return;
        }

        double[] grades = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập điểm cho sinh viên thứ %d: ", (i + 1));
            grades[i] = sc.nextDouble();
        }

        boolean isSorted = false; // Biến đánh dấu mảng đã sắp xếp hay chưa (phục vụ Binary Search)
        int choice;

        // 2. Vòng lặp Menu
        do {
            System.out.println("\n--- QUẢN LÝ ĐIỂM SINH VIÊN ---");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayGrades(grades);
                    break;
                case 2:
                    sortGradesMenu(grades, sc);
                    isSorted = true; // Sau khi chạy chức năng này, mảng đã được sắp xếp
                    break;
                case 3:
                    searchGradesMenu(grades, sc, isSorted);
                    break;
                case 4:
                    statisticsGrades(grades);
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (choice != 5);
    }

    // --- CÁC HÀM CHỨC NĂNG ---

    // Chức năng 1: Hiển thị
    public static void displayGrades(double[] arr) {
        System.out.print("Danh sách điểm: ");
        for (double d : arr) System.out.print(d + "  ");
        System.out.println();
    }

    // Chức năng 2: Sắp xếp
    public static void sortGradesMenu(double[] arr, Scanner sc) {
        System.out.println("1. Tăng dần (Bubble Sort)");
        System.out.println("2. Giảm dần (Selection Sort)");
        int type = sc.nextInt();

        if (type == 1) {
            // Bubble Sort - Tăng dần
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        } else {
            // Selection Sort - Giảm dần
            for (int i = 0; i < arr.length - 1; i++) {
                int maxIdx = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[maxIdx]) maxIdx = j;
                }
                double temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("Đã sắp xếp xong!");
        displayGrades(arr);
    }

    // Chức năng 3: Tìm kiếm
    public static void searchGradesMenu(double[] arr, Scanner sc, boolean isSorted) {
        System.out.print("Nhập điểm cần tìm: ");
        double target = sc.nextDouble();

        if (isSorted) {
            System.out.println("Sử dụng Binary Search (do mảng đã sắp xếp):");
            int low = 0, high = arr.length - 1, res = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) { res = mid; break; }
                if (arr[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
            if (res != -1) System.out.println("Tìm thấy tại vị trí index: " + res);
            else System.out.println("Không tìm thấy giá trị này.");
        } else {
            System.out.println("Sử dụng Linear Search:");
            boolean found = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    System.out.println("Tìm thấy tại vị trí index: " + i);
                    found = true;
                }
            }
            if (!found) System.out.println("Không tìm thấy giá trị này.");
        }
    }

    // Chức năng 4: Thống kê
    public static void statisticsGrades(double[] arr) {
        double sum = 0, max = arr[0], min = arr[0];
        for (double d : arr) {
            sum += d;
            if (d > max) max = d;
            if (d < min) min = d;
        }
        double avg = sum / arr.length;
        int countAboveAvg = 0;
        for (double d : arr) if (d >= avg) countAboveAvg++;

        System.out.println("--- Thống kê ---");
        System.out.println("Điểm trung bình: " + avg);
        System.out.println("Điểm cao nhất: " + max);
        System.out.println("Điểm thấp nhất: " + min);
        System.out.println("Số SV đạt trên trung bình: " + countAboveAvg);
    }
}