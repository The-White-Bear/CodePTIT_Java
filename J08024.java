package CodePTIT_Java;

import java.util.Scanner;

public class J08024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int X = findSmallestNumber(N);
            System.out.println(X);
        }
    }

    private static int findSmallestNumber(int N) {
        if (N == 0) {
            return 0;
        }
        int multipleOf9 = 9;
        while (multipleOf9 % N != 0) {
            multipleOf9 = multipleOf9 * 10 + 9;
        }
        return multipleOf9;
    }
}