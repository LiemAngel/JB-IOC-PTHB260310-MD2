package MD2.Session2;
import java.util.Scanner;
public class DocSoCoBaChuso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập vào một số trong khoảng 100-999
        System.out.print("Nhập vào một số (100-999): ");
        int n = scanner.nextInt();

        // Kiểm tra phạm vi hợp lệ
        if (n < 100 || n > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            // 2. Tách số thành hàng trăm, chục, đơn vị
            int hundreds = n / 100;         // Ví dụ: 123 / 100 = 1
            int tens = (n % 100) / 10;      // Ví dụ: (123 % 100) / 10 = 23 / 10 = 2
            int units = n % 10;             // Ví dụ: 123 % 10 = 3

            String result = "";

            // --- Đọc hàng trăm ---
            switch (hundreds) {
                case 1: result += "Một trăm "; break;
                case 2: result += "Hai trăm "; break;
                case 3: result += "Ba trăm "; break;
                case 4: result += "Bốn trăm "; break;
                case 5: result += "Năm trăm "; break;
                case 6: result += "Sáu trăm "; break;
                case 7: result += "Bảy trăm "; break;
                case 8: result += "Tám trăm "; break;
                case 9: result += "Chín trăm "; break;
            }

            // --- Đọc hàng chục ---
            switch (tens) {
                case 0: 
                    if (units != 0) result += "lẻ "; 
                    break;
                case 1: result += "mười "; break;
                default:
                    result += readDigit(tens) + " mươi ";
                    break;
            }

            // --- Đọc hàng đơn vị ---
            if (units != 0) {
                if (units == 5 && tens >= 1) {
                    result += "lăm";
                } else if (units == 1 && tens > 1) {
                    result += "mốt";
                } else {
                    result += readDigit(units);
                }
            }

            // 3. In kết quả tương ứng
            System.out.println("Kết quả: " + result.trim());
        }
        scanner.close();
    }

    // Hàm phụ để đọc các chữ số cơ bản bằng switch-case
    public static String readDigit(int digit) {
        switch (digit) {
            case 1: return "một";
            case 2: return "hai";
            case 3: return "ba";
            case 4: return "bốn";
            case 5: return "năm";
            case 6: return "sáu";
            case 7: return "bảy";
            case 8: return "tám";
            case 9: return "chín";
            default: return "";
        }
    }
}