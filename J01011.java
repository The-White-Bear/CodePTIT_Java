package CodePTIT_Java;

import java.util.Scanner;

public class J01011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            long lcm = findLCM(a, b);
            long gcd = findGCD(a, b);

            System.out.println(lcm + " " + gcd);
        }
    }

    public static long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static long findLCM(long a, long b) {
        return (a * b) / findGCD(a, b);
    }
}
