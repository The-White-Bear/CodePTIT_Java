package CodePTIT_Java;

import java.util.Scanner;

public class J02034 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] dem = new int[1000];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            dem[a[i]]++;
        }
        boolean ok=true;
        for (int i = 1; i <= a[n - 1];i++)
        {
            if (dem[i] == 0) {
                System.out.println(i);
                ok=false;
            }
        }
        if(ok)
        {
            System.out.println("Excellent!");
        }
    }
}
