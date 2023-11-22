package CodePTIT_Java;
import java.util.Scanner;
public class J03031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            int K = scanner.nextInt();

            String result = isFullString(S, K);
            System.out.println(result);
        }
    }

    public static String isFullString(String S, int K) {
        int[] charCount = new int[26];
        for (char c : S.toCharArray()) {
            charCount[c - 'a']++;
        }

        int missingChars = 0;
        for (int count : charCount) {
            if (count == 0) {
                missingChars++;
            }
        }
        int maxReplacements = Math.min(missingChars, K);
        if (missingChars <= K) {
            return "YES";
        } else {
            return "NO";
        }
    }
}