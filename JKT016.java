import java.util.Scanner;

public class JKT016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Số bộ test

        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt(); // Số ngày trong bộ test
            int[] prices = new int[n];

            // Đọc giá chứng khoán của từng ngày
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            // Tính nhịp chứng khoán và in ra kết quả
            calculateAndPrintStockTrend(prices);
        }
    }

    private static void calculateAndPrintStockTrend(int[] prices) {
        int[] trends = new int[prices.length];
        trends[0] = 1; // Nhịp của ngày đầu tiên luôn là 1

        for (int i = 1; i < prices.length; i++) {
            trends[i] = (prices[i] > prices[i - 1]) ? trends[i - 1] + 1 : 1;
        }

        // In ra kết quả
        for (int i = 0; i < trends.length; i++) {
            System.out.print(trends[i] + " ");
        }
        System.out.println();
    }
}
