import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Nhập cân nặng (kg)
        System.out.print("Nhập cân nặng của bạn (kg): ");
        double weight = input.nextDouble();

        // 2. Nhập chiều cao (m)
        System.out.print("Nhập chiều cao của bạn (xMyz m): ");
        double height = input.nextDouble();

        // Kiểm tra chiều cao để tránh lỗi chia cho 0
        if (height <= 0) {
            System.out.println("Chiều cao phải lớn hơn 0.");
        } else {
            // 3. Tính BMI theo công thức: BMI = Cân nặng / (Chiều cao * Chiều cao)
            double bmi = weight / (height * height);

            // 4. In ra chỉ số BMI (làm tròn 2 chữ số thập phân)
            System.out.printf("Chỉ số BMI của bạn là: %.2f\n", bmi);
            
            // Đánh giá nhanh (tùy chọn thêm)
            if (bmi < 18.5) {
                System.out.println("Đánh giá: Gầy");
            } else if (bmi < 25) {
                System.out.println("Đánh giá: Bình thường");
            } else {
                System.out.println("Đánh giá: Thừa cân");
            }
        }
        input.close();
}
}