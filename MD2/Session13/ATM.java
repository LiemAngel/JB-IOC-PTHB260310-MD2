import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double soDu       = 1_000_000; // Số dư ban đầu
        double soduToiThieu =  50_000; // Số dư tối thiểu bắt buộc duy trì

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           CHƯƠNG TRÌNH ATM           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf ("║  Số dư hiện tại : %,12.0f đồng  ║%n", soDu);
        System.out.printf ("║  Số dư tối thiểu: %,12.0f đồng  ║%n", soduToiThieu);
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("\nNhập số tiền muốn rút: ");

        try {
            // ── Bắt lỗi nhập không phải số ──
            double soTienRut = Double.parseDouble(sc.nextLine().trim());

            // ── Kiểm tra số tiền rút > số dư hiện có ──
            if (soTienRut > soDu) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút vượt quá số dư!");
            }

            // ── Kiểm tra số dư còn lại có đảm bảo tối thiểu ──
            if (soDu - soTienRut < soduToiThieu) {
                throw new IllegalStateException(
                    "Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }

            // ── Giao dịch thành công ──
            soDu -= soTienRut;
            System.out.println("\n Giao dịch thành công!");
            System.out.println("──────────────────────────────────────");
            System.out.printf("  Số tiền đã rút  : %,.0f đồng%n", soTienRut);
            System.out.printf("  Số dư còn lại   : %,.0f đồng%n", soDu);

        } catch (NumberFormatException e) {
            System.out.println("\n Lỗi: Vui lòng nhập một số hợp lệ!");

        } catch (IllegalArgumentException e) {
            System.out.println("\n " + e.getMessage());

        } catch (IllegalStateException e) {
            System.out.println("\n " + e.getMessage());

        } finally {
            System.out.println("──────────────────────────────────────");
            System.out.println("Cảm ơn bạn đã sử dụng dịch vụ ATM!");
            sc.close();
        }
    }
}