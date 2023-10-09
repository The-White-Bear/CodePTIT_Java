package CodePTIT_Java;
import java.util.Scanner;

public class J03027 {

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = removeDuplicates(s);
        if (result.isEmpty()) {
            System.out.println("Empty String");
        } else {
            System.out.println(result);
        }
    }
}