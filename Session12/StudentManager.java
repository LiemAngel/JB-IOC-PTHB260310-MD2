import java.util.ArrayList;
import java.util.Scanner;

// ==================== Lớp Student ====================
class Student {
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters
    public int getId()       { return id; }
    public String getName()  { return name; }
    public double getGpa()   { return gpa; }

    // Setters
    public void setId(int id)         { this.id = id; }
    public void setName(String name)  { this.name = name; }
    public void setGpa(double gpa)    { this.gpa = gpa; }

    // Xếp loại học lực dựa trên GPA
    public String getRank() {
        if (gpa >= 8.5)             return "Xuất sắc";
        else if (gpa >= 7.0)        return "Giỏi";
        else if (gpa >= 5.5)        return "Khá";
        else                        return "Trung bình / Yếu";
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-25s | %-5.2f | %-18s |",
                id, name, gpa, getRank());
    }
}

// ==================== Lớp quản lý chính ====================
public class StudentManager {

    private static ArrayList<Student> danhSach = new ArrayList<>();
    private static int nextId = 1; // ID tự tăng
    private static Scanner sc = new Scanner(System.in);

    // ---------- In tiêu đề bảng ----------
    private static void inTieuDe() {
        System.out.println("+------+---------------------------+-------+--------------------+");
        System.out.println("| ID   | Họ và tên                 | GPA   | Xếp loại           |");
        System.out.println("+------+---------------------------+-------+--------------------+");
    }

    // ---------- In dòng ngăn cách ----------
    private static void inDuoi() {
        System.out.println("+------+---------------------------+-------+--------------------+");
    }

    // ==================== Chức năng 1: Nhập danh sách ====================
    private static void nhapDanhSach() {
        System.out.print("\nNhập số lượng sinh viên muốn thêm (ít nhất 5): ");
        int soLuong;
        try {
            soLuong = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Số lượng không hợp lệ!");
            return;
        }
        if (soLuong < 1) {
            System.out.println("❌ Số lượng phải lớn hơn 0!");
            return;
        }

        for (int i = 1; i <= soLuong; i++) {
            System.out.println("\n--- Sinh viên thứ " + i + " ---");

            System.out.print("  Họ và tên : ");
            String ten = sc.nextLine().trim();
            while (ten.isEmpty()) {
                System.out.print("  Tên không được để trống. Nhập lại: ");
                ten = sc.nextLine().trim();
            }

            double diemGpa = -1;
            while (diemGpa < 0 || diemGpa > 10) {
                System.out.print("  GPA (0 - 10): ");
                try {
                    diemGpa = Double.parseDouble(sc.nextLine().trim());
                    if (diemGpa < 0 || diemGpa > 10)
                        System.out.println("  ❌ GPA phải trong khoảng 0 đến 10!");
                } catch (NumberFormatException e) {
                    System.out.println("  ❌ Vui lòng nhập số hợp lệ!");
                    diemGpa = -1;
                }
            }

            danhSach.add(new Student(nextId++, ten, diemGpa));
            System.out.println("  ✅ Đã thêm thành công!");
        }
    }

    // ==================== Chức năng 2: Hiển thị danh sách ====================
    private static void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("\n⚠️  Danh sách sinh viên đang trống!");
            return;
        }
        System.out.println("\n========== DANH SÁCH SINH VIÊN ==========");
        inTieuDe();
        for (Student sv : danhSach) {
            System.out.println(sv.toString());
        }
        inDuoi();
        System.out.println("Tổng số sinh viên: " + danhSach.size());
    }

    // ==================== Chức năng 3: Tìm kiếm theo tên ====================
    private static void timKiemTheoTen() {
        System.out.print("\nNhập tên sinh viên cần tìm: ");
        String tuKhoa = sc.nextLine().trim().toLowerCase();

        ArrayList<Student> ketQua = new ArrayList<>();
        for (Student sv : danhSach) {
            if (sv.getName().toLowerCase().contains(tuKhoa)) {
                ketQua.add(sv);
            }
        }

        if (ketQua.isEmpty()) {
            System.out.println("❌ Không tìm thấy sinh viên có tên chứa \"" + tuKhoa + "\".");
        } else {
            System.out.println("✅ Tìm thấy " + ketQua.size() + " sinh viên:");
            inTieuDe();
            for (Student sv : ketQua) {
                System.out.println(sv.toString());
            }
            inDuoi();
        }
    }

    // ==================== Chức năng 4: Phân loại theo GPA ====================
    private static void phanLoaiTheoGpa() {
        if (danhSach.isEmpty()) {
            System.out.println("\n⚠️  Danh sách sinh viên đang trống!");
            return;
        }

        String[] nhomTen   = {"Xuất sắc (GPA >= 8.5)",
                              "Giỏi (7.0 <= GPA < 8.5)",
                              "Khá (5.5 <= GPA < 7.0)",
                              "Trung bình / Yếu (GPA < 5.5)"};

        @SuppressWarnings("unchecked")
        ArrayList<Student>[] nhom = new ArrayList[4];
        for (int i = 0; i < 4; i++) nhom[i] = new ArrayList<>();

        for (Student sv : danhSach) {
            double g = sv.getGpa();
            if      (g >= 8.5) nhom[0].add(sv);
            else if (g >= 7.0) nhom[1].add(sv);
            else if (g >= 5.5) nhom[2].add(sv);
            else               nhom[3].add(sv);
        }

        System.out.println("\n========== PHÂN LOẠI SINH VIÊN THEO GPA ==========");
        for (int i = 0; i < 4; i++) {
            System.out.println("\n🎓 " + nhomTen[i] + " (" + nhom[i].size() + " sinh viên):");
            if (nhom[i].isEmpty()) {
                System.out.println("   (Không có sinh viên)");
            } else {
                inTieuDe();
                for (Student sv : nhom[i]) {
                    System.out.println(sv.toString());
                }
                inDuoi();
            }
        }
    }

    // ==================== Menu chính ====================
    private static void hienThiMenu() {
        System.out.println("\n================ MENU ================");
        System.out.println("1. Nhập danh sách sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Tìm kiếm sinh viên theo tên");
        System.out.println("4. Phân loại sinh viên theo GPA");
        System.out.println("0. Thoát chương trình");
        System.out.println("======================================");
        System.out.print("Lựa chọn của bạn: ");
    }

    // ==================== Main ====================
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   QUẢN LÝ DANH SÁCH SINH VIÊN        ║");
        System.out.println("╚══════════════════════════════════════╝");

        int luaChon;
        do {
            hienThiMenu();
            try {
                luaChon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1: nhapDanhSach();    break;
                case 2: hienThiDanhSach(); break;
                case 3: timKiemTheoTen();  break;
                case 4: phanLoaiTheoGpa(); break;
                case 0:
                    System.out.println("\n👋 Tạm biệt! Chương trình đã kết thúc.");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChon != 0);

        sc.close();
    }
}