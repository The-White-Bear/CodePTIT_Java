package CodePTIT_Java;
import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numTests; i++) {
            String num1Str = scanner.nextLine();
            String num2Str = scanner.nextLine();
            BigInteger num1 = new BigInteger(num1Str);
            BigInteger num2 = new BigInteger(num2Str);
            BigInteger lcm = num1.multiply(num2).divide(num1.gcd(num2));
            System.out.println(lcm);
        }
    }
}
