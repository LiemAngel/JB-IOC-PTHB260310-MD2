import java.util.ArrayList;
import java.util.Scanner;

public class ChuyenDoiChuoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> danhSachHopLe = new ArrayList<>();
        int soKhongHopLe = 0;

        System.out.println("==========================================");
        System.out.println("  CHUYỂN ĐỔI CHUỖI SANG SỐ NGUYÊN");
        System.out.println("==========================================");
        System.out.println("(Nhập 'exit' để kết thúc)");
        System.out.println();

        while (true) {
            System.out.print("Nhập chuỗi: ");
            String input = sc.nextLine().trim();

            // Điều kiện thoát
            if (input.equalsIgnoreCase("exit")) break;

            try {
                int soNguyen = Integer.parseInt(input);
                danhSachHopLe.add(soNguyen);
                System.out.println("  ✅ Hợp lệ → số nguyên: " + soNguyen);

            } catch (NumberFormatException e) {
                soKhongHopLe++;
                System.out.println("  ❌ Không hợp lệ: \"" + input + "\" không phải số nguyên.");
            }
        }

        // In kết quả
        System.out.println();
        System.out.println("==================== KẾT QUẢ ====================");
        System.out.println("Số chuỗi hợp lệ   : " + danhSachHopLe.size());
        System.out.println("Số chuỗi không hợp lệ: " + soKhongHopLe);
        System.out.println("Danh sách số nguyên hợp lệ: " + danhSachHopLe);
        System.out.println("==================================================");

        sc.close();
    }
}