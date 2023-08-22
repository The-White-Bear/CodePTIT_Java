package CodePTIT_Java;

import java.util.*;

public class J01014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long largestPrimeDivisor = findLargestPrimeDivisor(n);
            System.out.println(largestPrimeDivisor);
        }
    }

    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static long findLargestPrimeDivisor(long num) {
        long largestPrime = -1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0 && isPrime(i)) {
                largestPrime = i;
            }
            while (num % i == 0) {
                num /= i;
            }
        }
        if (num > 1) {
            largestPrime = Math.max(largestPrime, num);
        }
        return largestPrime;
    }
}
