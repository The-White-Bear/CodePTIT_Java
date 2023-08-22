package CodePTIT_Java;

import java.util.Scanner;

public class J01007{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxN = 92;
        long[] fibo = new long[maxN + 1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= maxN; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            long q = scanner.nextLong();
            if (check(q, fibo)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }


    public static boolean check(long n, long[] fibo) {
        if(n==0)
        {
            return true;
        }
        for (int i = 1; i <= 92; i++) {
            if (n == fibo[i]) {
                return true;
            }
        }
        return false;
    }
}
