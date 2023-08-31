package CodePTIT_Java;

import java.util.Scanner;

public class J03021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String s=scanner.next();
            StringBuilder sb=new StringBuilder();
            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            System.out.println(sb);
        }
    }
}
