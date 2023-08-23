package CodePTIT_Java;
import java.util.Scanner;

public class J01024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            if (check(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2') {
                return false;
            }
        }
        return true;
    }
}
