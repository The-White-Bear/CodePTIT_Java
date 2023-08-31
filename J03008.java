package CodePTIT_Java;
import java.util.Scanner;

public class J03008 {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBeautiful(String numStr) {
        int length = numStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            int digit = numStr.charAt(i) - '0';
            if (!isPrime(digit)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTests; i++) {
            String numStr = scanner.nextLine();
            if (isBeautiful(numStr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
