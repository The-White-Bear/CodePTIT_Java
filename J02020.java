package CodePTIT_Java;
import java.util.Scanner;

public class J02020 {
    static int total = 0;
    public static void generateCombinations(int n, int k, int[] currentCombination, int start) {
        if (k == 0) {
            for (int i = 0; i < currentCombination.length; i++) {
                System.out.print(currentCombination[i] + " ");
            }
            System.out.println();
            total++;
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination[currentCombination.length - k] = i;
            generateCombinations(n, k - 1, currentCombination, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] currentCombination = new int[k];

        generateCombinations(n, k, currentCombination, 1);
        System.out.println("Tong cong co " +total+" to hop");
        scanner.close();
    }
}
