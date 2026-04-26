import java.util.Scanner;

public class TinhDienTichHinhTron {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner để nhận dữ liệu từ bàn phím
        Scanner input = new Scanner(System.lineSeparator() == null ? System.in : System.in);
        
        System.out.print("Nhập bán kính : ");
        
        // Sử dụng biến để lưu trữ bán kính (radius)
        double radius = input.nextDouble();
        
        // Sử dụng toán tử nhân để tính diện tích theo công thức: A = π * r * r
        // Ở đây ta dùng Math.PI để có độ chính xác cao nhất
        double area = Math.PI * radius * radius;
        
        // Hiển thị diện tích, định dạng lấy 2 chữ số thập phân để khớp với Test case
        if (area == (long) area) {
            // Nếu là số nguyên (như trường hợp bán kính = 0) thì in số nguyên
            System.out.printf("Diện tích : %d\n", (long)area);
        } else {
            System.out.printf("Diện tích : %.2f\n", area);
        }
        
        input.close();
    }
}