package CodePTIT_Java;

import java.util.Scanner;

public class J01008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            long n = scanner.nextLong();
            System.out.print("Test "  + t+": ");
            primeFactorization(n);
            System.out.println();
        }

        scanner.close();
    }

    public static void primeFactorization(long n) {
        for (long i = 2; i * i <= n; i++) {
            int cnt = 0;
            while (n % i == 0) {
                cnt++;
                n /= i;
            }
            if (cnt > 0) {
                System.out.print(i + "(" + cnt + ") ");
            }
        }
        if (n > 1) {
            System.out.print(n + "(" + 1 + ") ");
        }
    }
}
