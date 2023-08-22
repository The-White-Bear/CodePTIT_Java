package CodePTIT_Java;

import java.util.Scanner;

public class J01016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        scanner.close();

        int count4 = 0;
        int count7 = 0;

        for (int i = 0; i < N.length(); i++) {
            char digit = N.charAt(i);
            if (digit == '4') {
                count4++;
            } else if (digit == '7') {
                count7++;
            }
        }

        if (count4 + count7 == 4 || count4 + count7 == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
