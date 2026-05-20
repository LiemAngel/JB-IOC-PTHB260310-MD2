import java.util.Scanner;

public class KiemTraSoNguyenTo {

    // ========== Hàm kiểm tra số nguyên tố ==========
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // ========== Main ==========
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   KIỂM TRA SỐ NGUYÊN TỐ");
        System.out.println("========================================");
        System.out.print("Nhập một số nguyên: ");

        try {
            // Đọc dòng nhập từ bàn phím rồi parse sang int
            String input = sc.nextLine().trim();
            int n = Integer.parseInt(input); // Ném NumberFormatException nếu không phải số nguyên

            // Kiểm tra số không hợp lệ (<= 0)
            if (n <= 0) {
                throw new IllegalArgumentException(
                    "Số " + n + " không hợp lệ! Số để kiểm tra nguyên tố phải lớn hơn 0.");
            }

            // Kiểm tra và in kết quả
            if (laSoNguyenTo(n)) {
                System.out.println("----------------------------------------");
                System.out.println(" " + n + " LÀ số nguyên tố.");
            } else {
                System.out.println("----------------------------------------");
                System.out.println(" " + n + " KHÔNG phải là số nguyên tố.");
            }

        } catch (NumberFormatException e) {
            // Người dùng nhập chữ, ký tự đặc biệt, hoặc số thực
            System.out.println("----------------------------------------");
            System.out.println("  Lỗi: Dữ liệu nhập không phải là số nguyên!");
            System.out.println("   Chi tiết: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Người dùng nhập số âm hoặc số 0
            System.out.println("----------------------------------------");
            System.out.println("  Lỗi: " + e.getMessage());

        } finally {
            System.out.println("========================================");
            System.out.println("Chương trình kết thúc.");
            sc.close();
        }
    }
}