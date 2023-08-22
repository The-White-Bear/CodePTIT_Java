package CodePTIT_Java;

import java.util.Scanner;

public class J01009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxN = 21;
        long[] array = new long[maxN + 1];
        array[1] = 1;

        for (int i = 2; i <= maxN; i++) {
            array[i] = (array[i - 1] * i);
        }
        int q = scanner.nextInt();
        long sum = 0;
        for (int j = 1; j <= q; j++) {
            sum += array[j];
        }
        System.out.println(sum);

        scanner.close();
    }
}



