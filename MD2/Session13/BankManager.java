import java.util.ArrayList;
import java.util.List;

public class BankManager {

    // ==================== In danh sách tài khoản ====================
    static void inDanhSach(List<BankAccount> accounts) {
        System.out.println("  +--------------+-----------------+");
        System.out.println("  | Số tài khoản |       Số dư     |");
        System.out.println("  +--------------+-----------------+");
        for (BankAccount acc : accounts) {
            System.out.println("  " + acc);
        }
        System.out.println("  +--------------+-----------------+");
    }

    // ==================== Thực hiện giao dịch an toàn ====================
    static void thucHienGiaoDich(String moTa, Runnable giaoDich) {
        System.out.println("\n▶ " + moTa);
        try {
            giaoDich.run();
        } catch (IllegalArgumentException e) {
            System.out.println("  ❌ Lỗi: " + e.getMessage());
        }
    }

    // ==================== Main ====================
    public static void main(String[] args) {

        // ── Khởi tạo danh sách tài khoản ──
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("TK001", 5_000_000));
        accounts.add(new BankAccount("TK002", 2_000_000));
        accounts.add(new BankAccount("TK003",   500_000));

        BankAccount tk001 = accounts.get(0);
        BankAccount tk002 = accounts.get(1);
        BankAccount tk003 = accounts.get(2);

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║      TRÌNH QUẢN LÝ GIAO DỊCH NGÂN HÀNG  ║");
        System.out.println("╚══════════════════════════════════════════╝");

        System.out.println("\n📋 DANH SÁCH TÀI KHOẢN BAN ĐẦU:");
        inDanhSach(accounts);

        // ══════════════ GỬI TIỀN ══════════════
        System.out.println("\n════════════════ GỬI TIỀN ════════════════");

        thucHienGiaoDich("[TK001] Gửi 1,000,000 đ (hợp lệ)",
            () -> tk001.deposit(1_000_000));

        thucHienGiaoDich("[TK002] Gửi -500,000 đ (số âm - lỗi)",
            () -> tk002.deposit(-500_000));

        thucHienGiaoDich("[TK003] Gửi 0 đ (bằng 0 - lỗi)",
            () -> tk003.deposit(0));

        // ══════════════ RÚT TIỀN ══════════════
        System.out.println("\n════════════════ RÚT TIỀN ════════════════");

        thucHienGiaoDich("[TK001] Rút 2,000,000 đ (hợp lệ)",
            () -> tk001.withdraw(2_000_000));

        thucHienGiaoDich("[TK002] Rút 5,000,000 đ (vượt số dư - lỗi)",
            () -> tk002.withdraw(5_000_000));

        thucHienGiaoDich("[TK003] Rút -100,000 đ (số âm - lỗi)",
            () -> tk003.withdraw(-100_000));

        // ══════════════ CHUYỂN TIỀN ══════════════
        System.out.println("\n══════════════ CHUYỂN TIỀN ══════════════");

        thucHienGiaoDich("[TK001] Chuyển 1,000,000 đ sang TK002 (hợp lệ)",
            () -> tk001.transfer(1_000_000, "TK002", accounts));

        thucHienGiaoDich("[TK003] Chuyển 1,000,000 đ sang TK001 (vượt số dư - lỗi)",
            () -> tk003.transfer(1_000_000, "TK001", accounts));

        thucHienGiaoDich("[TK002] Chuyển 500,000 đ sang TK999 (tài khoản không tồn tại - lỗi)",
            () -> tk002.transfer(500_000, "TK999", accounts));

        thucHienGiaoDich("[TK002] Chuyển -200,000 đ sang TK003 (số âm - lỗi)",
            () -> tk002.transfer(-200_000, "TK003", accounts));

        // ══════════════ KẾT QUẢ CUỐI ══════════════
        System.out.println("\n📋 DANH SÁCH TÀI KHOẢN SAU GIAO DỊCH:");
        inDanhSach(accounts);
    }
}