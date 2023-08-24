package CodePTIT_Java;
import java.util.Scanner;
import java.lang.Math;
public class J01026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        String[] results = new String[numTests];

        for (int i = 0; i < numTests; i++) {
            int num = scanner.nextInt();
            if (isPerfectSquare(num)) {
                results[i] = "YES";
            } else {
                results[i] = "NO";
            }
        }
        for (String result : results) {
            System.out.println(result);
        }
    }

    static boolean isPerfectSquare(int n) {
        int sqrtN = (int) Math.sqrt(n);
        return sqrtN * sqrtN == n;
    }
}
