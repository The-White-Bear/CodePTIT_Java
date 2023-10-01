package CodePTIT_Java;
import java.util.Scanner;

public class J03032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < T; t++) {
            String input = scanner.nextLine();
            String reversed = reverseWords(input);
            System.out.println(reversed);
        }

        scanner.close();
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversedStr = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversedStr.append(reversedWord);

            if (i < words.length - 1) {
                reversedStr.append(" ");
            }
        }
        return reversedStr.toString();
    }
}
