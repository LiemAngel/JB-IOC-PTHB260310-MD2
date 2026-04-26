package MD2.Session3;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class QuanLyBanHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");        
        // Thiết lập định dạng tiền tệ (dùng dấu chấm cho phần nghìn)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);

        // --- 1. NHẬP DỮ LIỆU ---
        System.out.print("Nhập tên khách hàng: ");
        String tenKhachHang = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double gia = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        System.out.print("Khách có thẻ thành viên (true/false): ");
        boolean laThanhVien = sc.nextBoolean();

        // --- 2. TÍNH TOÁN ---
        double thanhTien = gia * soLuong;
        
        // Giảm giá 10% nếu là thành viên
        double giamGia = laThanhVien ? (thanhTien * 0.1) : 0;
        
        // Tiền VAT 8% (Tính trên thành tiền chưa giảm)
        double tienVAT = thanhTien * 0.08;
        
        // Tổng tiền thanh toán = Thành tiền – Giảm giá + VAT
        double tongThanhToan = thanhTien - giamGia + tienVAT;

        // --- 3. XUẤT KẾT QUẢ ---
        System.out.println("\n------------------------------------");
        System.out.println("Khách hàng: " + tenKhachHang);
        System.out.println("Sản phẩm: " + tenSanPham);
        System.out.println("Giá: " + df.format(gia) + " VNĐ");
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + df.format(thanhTien) + " VNĐ");
        System.out.println("Giảm giá: " + df.format(giamGia));
        System.out.println("Tiền VAT: " + df.format(tienVAT));
        System.out.println("Tổng tiền thanh toán: " + df.format(tongThanhToan) + " VNĐ");
        sc.close();
    }
}