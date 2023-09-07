package CodePTIT_Java;
import java.util.Scanner;

public class J02105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print("List("+(i+1)+") = ");
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1  ) {
                    System.out.print(j+1 + " ");
                }
            }
            System.out.println();
        }
    }
}