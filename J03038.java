package CodePTIT_Java;
import java.util.HashSet;
import java.util.Scanner;

public class J03038 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        int uniqueCharacterCount = countUniqueCharacters(s);
        System.out.println(uniqueCharacterCount);
    }

    public static int countUniqueCharacters(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                uniqueChars.add(c);
            }
        }

        return uniqueChars.size();
    }
}
