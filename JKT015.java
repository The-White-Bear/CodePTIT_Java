import java.util.Scanner;
import java.util.Stack;

public class JKT015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '-') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (c == '<') {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (c == '>') {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else {
                leftStack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!leftStack.isEmpty()) {
            result.append(leftStack.pop());
        }
        result.reverse();
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        System.out.println(result.toString());
    }
}