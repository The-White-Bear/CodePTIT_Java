package CodePTIT_Java;

import java.util.Scanner;

public class J03026{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(a.equals(b) ? -1 : Math.max(a.length(), b.length()));
        }
    }
}