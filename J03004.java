package CodePTIT_Java;
import java.util.Scanner;

public class J03004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            String fullName = scanner.nextLine().trim();
            String[] nameParts = fullName.split("\\s+");
            StringBuilder normalizedFullName = new StringBuilder();

            for (String namePart : nameParts) {
                if (!namePart.isEmpty()) {
                    String normalizedPart = namePart.substring(0, 1).toUpperCase() +
                            namePart.substring(1).toLowerCase();
                    normalizedFullName.append(normalizedPart).append(" ");
                }
            }

            System.out.println(normalizedFullName.toString().trim());
        }
    }
}
