import java.util.*;

public class J08011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        String[] numbers = inputString.split("\\s+");
        Map<String, Integer> mp = new HashMap<>();

        for (String num : numbers) {
            if (check(num)) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
        }

        // Convert the map to a list and sort it based on occurrences
        List<Map.Entry<String, Integer>> sortedCounts = new ArrayList<>(mp.entrySet());
        sortedCounts.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print the result
        for (Map.Entry<String, Integer> entry : sortedCounts) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static boolean check(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (Character.getNumericValue(number.charAt(i)) > Character.getNumericValue(number.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
