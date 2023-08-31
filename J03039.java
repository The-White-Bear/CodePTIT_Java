package CodePTIT_Java;
import java.util.Scanner;
import java.math.BigInteger;

public class J03039 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            String[] numberStr = new  String[2];
            numberStr[0] = scanner.next();
            numberStr[1] = scanner.next();
            BigInteger number1 = new BigInteger(numberStr[0]);
            BigInteger number2 = new BigInteger(numberStr[1]);

            if (number1.mod(number2).equals(BigInteger.ZERO)||number2.mod(number1).equals(BigInteger.ZERO)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}