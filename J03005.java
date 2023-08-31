package CodePTIT_Java;
import java.util.Scanner;

public class J03005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            String fullName = scanner.nextLine().trim();
            String[] nameParts = fullName.split("\\s+");
            StringBuilder normalizedFullName = new StringBuilder();

            nameParts[0] = nameParts[0].toUpperCase();

            for (int i = 1; i < nameParts.length; i++) {
                nameParts[i] = nameParts[i].substring(0, 1).toUpperCase() +
                        nameParts[i].substring(1).toLowerCase();
                normalizedFullName.append(nameParts[i]).append(" ");
            }
            normalizedFullName.delete(normalizedFullName.length() - 1, normalizedFullName.length());
            normalizedFullName.append(", ").append(nameParts[0]);

            System.out.println(normalizedFullName.toString().trim());
        }
    }
}
