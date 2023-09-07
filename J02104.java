package CodePTIT_Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J02104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        List<Edge> edges = matrixToEdges(matrix);
        for (Edge edge : edges) {
            System.out.println("("+edge.start + "," + edge.end+")");
        }
    }

    static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static List<Edge> matrixToEdges(int[][] matrix) {
        List<Edge> edges = new ArrayList<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i<=j) {
                    edges.add(new Edge(i+1, j+1));
                }
            }
        }
        return edges;
    }
}