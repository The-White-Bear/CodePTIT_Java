
package CodePTIT_Java;
import java.util.Scanner;

public class J02014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < n; i++) {
                rightSum += arr[i];
            }

            int balanceIndex = -1;
            for (int i = 0; i < n; i++) {
                rightSum -= arr[i];
                if (leftSum == rightSum) {
                    balanceIndex = i+1;
                    break;
                }
                leftSum += arr[i];
            }


            System.out.println(balanceIndex);

            t--;
        }
    }
}