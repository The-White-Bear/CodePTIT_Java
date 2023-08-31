package CodePTIT_Java;
import java.util.Scanner;

public class J01022 {

    static long[] fibonacci;

    static void precomputeFibonacci() {
        fibonacci = new long[100];
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        for (int i = 3; i <= 93; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
    }

    static char find(int n, long i) {
        if (n == 1) {
            return '0';
        }
        if (n == 2) {
            return '1';
        }
        if (i > fibonacci[n - 2]) {
            return find(n - 1, i - fibonacci[n - 2]);
        } else {
            return find(n - 2, i);
        }
    }

    public static void main(String[] args) {
        precomputeFibonacci();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long i = scanner.nextLong();
            char res = find(n, i);
            System.out.println(res);
        }
    }
}