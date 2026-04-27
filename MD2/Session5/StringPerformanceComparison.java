package MD2.Session5;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 100000; // Bạn có thể tăng lên 1 triệu, nhưng hãy cẩn thận với String vì nó rất chậm
        long startTime, endTime;

        // 1. Đo lường với String
        String str = "Hello";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            str += " World";
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String: " + (endTime - startTime) + " ms");

        // 2. Đo lường với StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sb.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: " + (endTime - startTime) + " ms");

        // 3. Đo lường với StringBuffer
        StringBuffer sbf = new StringBuffer("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sbf.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: " + (endTime - startTime) + " ms");

        // Nhận xét
        System.out.println("\n--- Nhận xét ---");
        System.out.println("- String: Chậm nhất vì String là immutable (bất biến). Mỗi lần nối, Java tạo ra một đối tượng mới, gây tốn bộ nhớ và thời gian.");
        System.out.println("- StringBuilder: Nhanh nhất vì nó thay đổi trực tiếp trên vùng nhớ cũ, không tạo đối tượng mới. Phù hợp cho đơn luồng.");
        System.out.println("- StringBuffer: Nhanh tương đương StringBuilder nhưng chậm hơn một chút do có cơ chế 'synchronized' để an toàn trong đa luồng (thread-safe).");
    }
}
