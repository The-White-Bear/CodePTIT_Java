package CodePTIT_Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CodePTIT_Java.Pair;
public class J07018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] adj = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = scanner.nextInt();
            }
        }

        List<Pair<Integer, Integer>> edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adj[i][j] == 1) {

                    edgeList.add(new Pair<>(i+1, j+1));
                }
            }
        }


        for (Pair<Integer, Integer> edge : edgeList) {
            System.out.println(edge);
        }
    }
}
