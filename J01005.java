package CodePTIT_Java;

import java.util.Scanner;

public class J01005 {
    public static Scanner scanner = new Scanner(System.in);

    public static void Testcase() {
        int n= scanner.nextInt();
        int h=scanner.nextInt();
        for(double i=1d;i<n;i++)
        {
            System.out.printf("%.6f ", Math.sqrt(i / n) * h);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t=scanner.nextInt();
        while(t-->0)
        {
            Testcase();
        }
    }
}
