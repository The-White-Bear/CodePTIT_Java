package CodePTIT_Java;

import java.util.Scanner;

public class J01010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String numStr = scanner.next();
            String result = performSplit(numStr);
            System.out.println(result);
        }
    }

    public static String performSplit(String numStr) {
        char[] numArray = numStr.toCharArray();
        for (int i = 0; i < numArray.length; i++) {
            int digit = numArray[i] - '0';
            if (digit != 0 && digit != 1 && digit != 8 && digit != 9) {
                return "INVALID";
            }
            if (digit == 8 || digit == 9) {
                numArray[i] = '0';
            }
        }
        String result = new String(numArray);
        result = result.replaceFirst("^0+(?!$)", "");
        if (result.isEmpty() || result.equals("0")) {
            return "INVALID";
        }
        return result;
    }
}
