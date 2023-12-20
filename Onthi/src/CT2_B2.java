import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CT2_B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of elements in the array
            ArrayList<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            ArrayList<Integer> result = findStandingHeads(a);

            for (int i = 0; i < result.size() - 1; i++) {
                System.out.print(result.get(i) + " ");
            }

            if (!result.isEmpty()) {
                System.out.println(result.get(result.size() - 1));
            }
        }
    }

    private static ArrayList<Integer> findStandingHeads(ArrayList<Integer> a) {
        ArrayList<Integer> standingHeads = new ArrayList<>();
        int currentMax = 0;

        // Traverse the array from right to left
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) > currentMax) {
                standingHeads.add(a.get(i));
                currentMax = a.get(i);
            }
        }

        // Reverse the result to print in decreasing order
        Collections.reverse(standingHeads);

        return standingHeads;
    }
}
