package CodePTIT_Java;

import java.math.BigInteger;
import java.util.Scanner;

public class J03012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            String a=scanner.nextLine();
            String b=scanner.nextLine();
            BigInteger number1 = new BigInteger(a);
            BigInteger number2 = new BigInteger(b);
            System.out.println(number1.add(number2));
        }
    }
}
