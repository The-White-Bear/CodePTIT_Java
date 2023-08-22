package CodePTIT_Java;

import java.util.Scanner;

public class J01017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        for (int i = 0; i < numTests; i++) {
            String numStr = scanner.next();
            if (check(numStr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean check(String numStr) {
        for (int i = 0; i < numStr.length() - 1; i++) {
            int diff = Math.abs(numStr.charAt(i) - numStr.charAt(i + 1));
            if (diff != 1) {
                return false;
            }
        }

        return true;
    }
}
