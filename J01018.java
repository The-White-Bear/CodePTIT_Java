package CodePTIT_Java;

import java.util.Scanner;
import java.lang.Math;
import static java.lang.System.out;

public class J01018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            String s = scanner.next();

            if (check1(s) && check2(s)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }

    public static boolean check1(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != 2) {
                return false;
            }
        }
        return true;
    }

    public static boolean check2(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        return sum % 10 == 0;
    }
}
