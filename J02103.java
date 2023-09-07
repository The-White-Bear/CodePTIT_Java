package CodePTIT_Java;
import java.util.Scanner;

public class J02103{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            int[][] result = multiplyWithTranspose(a);

            System.out.println("Test " + testCase + ":");
            for (int[] row : result) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    static int[][] multiplyWithTranspose(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] transposeA = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposeA[j][i] = a[i][j];
            }
        }
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += a[i][k] * transposeA[k][j];
                }
            }
        }

        return result;
    }
}