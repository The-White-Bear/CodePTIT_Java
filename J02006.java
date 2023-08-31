package CodePTIT_Java;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class J02006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            setA.add(num);
        }
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            setB.add(num);
        }
        Set<Integer> union = new TreeSet<>(setA);
        union.addAll(setB);
        for (int num : union) {
            System.out.print(num + " ");
        }
    }
}