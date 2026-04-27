package MD2.Session5;

import java.util.Scanner;

public class StringManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ CHUỖI =====");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự (Chữ hoa, thường, số, đặc biệt)");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra chuỗi đối xứng (Palindrome)");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Mời bạn nhập chuỗi: ");
                    str = sc.nextLine();
                    break;

                case 2:
                    if (str.isEmpty()) {
                        System.out.println("Vui lòng nhập chuỗi trước!");
                    } else {
                        int upper = 0, lower = 0, digit = 0, special = 0;
                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (Character.isUpperCase(ch)) upper++;
                            else if (Character.isLowerCase(ch)) lower++;
                            else if (Character.isDigit(ch)) digit++;
                            else special++;
                        }
                        System.out.println("Kết quả đếm:");
                        System.out.println("- Chữ hoa: " + upper);
                        System.out.println("- Chữ thường: " + lower);
                        System.out.println("- Chữ số: " + digit);
                        System.out.println("- Ký tự đặc biệt: " + special);
                    }
                    break;

                case 3:
                    StringBuilder reverseStr = new StringBuilder(str);
                    System.out.println("Chuỗi đảo ngược: " + reverseStr.reverse().toString());
                    break;

                case 4:
                    if (isPalindrome(str)) {
                        System.out.println("Đây là chuỗi đối xứng (Palindrome).");
                    } else {
                        System.out.println("Đây không phải chuỗi đối xứng.");
                    }
                    break;

                case 5:
                    if (str.isEmpty()) {
                        System.out.println("Vui lòng nhập chuỗi trước!");
                    } else {
                        // Xóa khoảng trắng thừa đầu cuối và thay thế khoảng trắng giữa bằng 1 dấu cách
                        String normalized = str.trim().replaceAll("\\s+", " ");
                        if (!normalized.isEmpty()) {
                            // Viết hoa chữ cái đầu
                            normalized = normalized.substring(0, 1).toUpperCase() + normalized.substring(1);
                        }
                        str = normalized;
                        System.out.println("Chuỗi sau khi chuẩn hóa: " + str);
                    }
                    break;

                case 6:
                    System.out.println("Tạm biệt!");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Hàm kiểm tra Palindrome
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return false;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}