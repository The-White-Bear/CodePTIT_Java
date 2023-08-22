package CodePTIT_Java;

import java.util.Scanner;

public class J01006{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxN = 92;
        long[] fibo = new long[maxN+1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= 92; i++)
        {
            fibo[i]=fibo[i-1]+fibo[i-2];
        }

        int t=scanner.nextInt();

        for(int i=1;i<=t;i++)
        {
            int q=scanner.nextInt();
            System.out.println(fibo[q]);
        }
        scanner.close();
    }
}
