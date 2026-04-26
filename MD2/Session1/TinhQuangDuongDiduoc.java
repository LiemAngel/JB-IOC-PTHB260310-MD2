import java.util.Scanner;
public class TinhQuangDuongDiduoc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Nhập vận tốc (km/h)
        System.out.print("Nhập vận tốc của bạn (km/h): ");
        double speed = input.nextDouble();

        // 2. Nhập thời gian (giờ)
        System.out.print("Nhập thời gian bạn đã đi (giờ): ");
        double time = input.nextDouble();

        // Kiểm tra thời gian để tránh lỗi
        if (time < 0) {
            System.out.println("Thời gian phải lớn hơn hoặc bằng 0.");
        } else {
            // 3. Tính quãng đường theo công thức: Distance = Speed * Time
            double distance = speed * time;

            // 4. In ra quãng đường đã đi được (làm tròn 2 chữ số thập phân)
            System.out.printf("Quãng đường bạn đã đi được là: %.2f km\n", distance);
        }
        input.close();
    }
}
