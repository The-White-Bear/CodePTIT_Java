import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class J07008 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("DAYSO.in"));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        reader.close();

        List<String> result = new ArrayList<>();

        for (int i = 1; i < (1 << n); i++) {
            List<Integer> subsequence = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsequence.add(a[j]);
                }
            }

            if (isIncreasing(subsequence) && subsequence.size() > 1) {
                StringBuilder sb = new StringBuilder();
                for (int num : subsequence) {
                    sb.append(num).append(" ");
                }
                result.add(sb.toString().trim());
            }
        }

        Collections.sort(result);

        for (String sequence : result) {
            System.out.println(sequence);
        }
    }

    private static boolean isIncreasing(List<Integer> sequence) {
        for (int i = 1; i < sequence.size(); i++) {
            if (sequence.get(i) <= sequence.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
