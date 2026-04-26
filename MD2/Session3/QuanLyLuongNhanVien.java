package MD2.Session3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class QuanLyLuongNhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");
        
        int luaChon;
        int soNhanVien = 0;
        double tongLuong = 0;
        double luongCaoNhat = -1;
        double luongThapNhat = 500000001; // Lớn hơn mức trần 500M
        double tongTienThuong = 0;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                    while (true) {
                        System.out.print("Nhập lương: ");
                        double luong = sc.nextDouble();

                        if (luong == -1) break;

                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                            continue;
                        }

                        // Phân loại và tính thưởng ngay để tích lũy
                        String phanLoai = "";
                        double tileThuong = 0;

                        if (luong < 5000000) {
                            phanLoai = "Thấp";
                            tileThuong = 0.05;
                        } else if (luong <= 15000000) {
                            phanLoai = "Trung bình";
                            tileThuong = 0.10;
                        } else if (luong <= 50000000) {
                            phanLoai = "Khá";
                            tileThuong = 0.15;
                        } else {
                            phanLoai = "Cao";
                            tileThuong = (luong <= 100000000) ? 0.20 : 0.25;
                        }

                        System.out.println("-> Phân loại: " + phanLoai);

                        // Cập nhật dữ liệu thống kê
                        soNhanVien++;
                        tongLuong += luong;
                        tongTienThuong += (luong * tileThuong);
                        
                        if (luong > luongCaoNhat) luongCaoNhat = luong;
                        if (luong < luongThapNhat) luongThapNhat = luong;
                    }
                    break;

                case 2:
                    System.out.println("\n--- Thống kê ---");
                    if (soNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("Số nhân viên: " + soNhanVien);
                        System.out.println("Tổng lương: " + df.format(tongLuong) + " VNĐ");
                        System.out.println("Lương trung bình: " + df.format(tongLuong / soNhanVien) + " VNĐ");
                        System.out.println("Lương cao nhất: " + df.format(luongCaoNhat) + " VNĐ");
                        System.out.println("Lương thấp nhất: " + df.format(luongThapNhat) + " VNĐ");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Tính tổng số tiền thưởng nhân viên ---");
                    if (soNhanVien == 0) {
                        System.out.println("Chưa có nhân viên nào để tính thưởng!");
                    } else {
                        System.out.println("Tổng tiền thưởng nhân viên: " + df.format(tongTienThuong) + " VNĐ");
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 4);
        sc.close();
    }
}