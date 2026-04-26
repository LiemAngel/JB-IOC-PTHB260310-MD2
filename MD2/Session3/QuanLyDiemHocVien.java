package MD2.Session3;

import java.util.Scanner;

public class QuanLyDiemHocVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");        
        int luaChon;
        
        // Các biến lưu trữ thống kê
        int soLuong = 0;
        double tongDiem = 0;
        double diemCaoNhat = -1.0;
        double diemThapNhat = 11.0;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập điểm: ");
                        double diem = sc.nextDouble();

                        if (diem == -1) break;

                        if (diem < 0 || diem > 10) {
                            System.out.println("Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }

                        // Xếp loại học lực
                        String xepLoai = "";
                        if (diem < 5) xepLoai = "Yếu";
                        else if (diem < 7) xepLoai = "Trung bình";
                        else if (diem < 8) xepLoai = "Khá";
                        else if (diem < 9) xepLoai = "Giỏi";
                        else xepLoai = "Xuất sắc";
                        
                        System.out.println("Học lực: " + xepLoai);

                        // Cập nhật thống kê
                        soLuong++;
                        tongDiem += diem;
                        if (diem > diemCaoNhat) diemCaoNhat = diem;
                        if (diem < diemThapNhat) diemThapNhat = diem;
                    }
                    break;

                case 2:
                    System.out.println("\n--- KẾT QUẢ ---");
                    if (soLuong == 0) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        System.out.println("Số học viên đã nhập: " + soLuong);
                        System.out.printf("Điểm trung bình: %.2f\n", (tongDiem / soLuong));
                        System.out.printf("Điểm cao nhất: %.2f\n", diemCaoNhat);
                        System.out.printf("Điểm thấp nhất: %.2f\n", diemThapNhat);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 3);
        
        sc.close();
    }
}