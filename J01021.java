package CodePTIT_Java;
import java.util.Scanner;

public class J01021 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            if (a == 0 && b == 0) {
                break;
            }

            long result = power(a, b);
            System.out.println(result);
        }

        scanner.close();
    }

    static long power(long base, long exponent) {
        long result=1;
        while(exponent>0)
        {
            if((exponent&1)==1)
            {
                result=(result*base)%MOD;
            }
            base=(base*base)%MOD;
            exponent=exponent>>1;
        }
        return result;
    }
}
