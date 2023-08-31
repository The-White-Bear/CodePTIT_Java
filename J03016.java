package CodePTIT_Java;
import java.util.Scanner;
import java.math.BigInteger;

public class J03016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            String numberStr = scanner.next().trim();
            BigInteger number = new BigInteger(numberStr);
            BigInteger divisor = new BigInteger("11");

            if (number.mod(divisor).equals(BigInteger.ZERO)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
