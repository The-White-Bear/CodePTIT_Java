package CodePTIT_Java;
import java.util.*;
public class J07021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng xuống kết thúc

        for (int t = 0; t < T; t++) {
            String expression = scanner.nextLine();
            Stack<Integer> stack = new Stack<>();
            int count = 1;

            // Duyệt qua từng ký tự trong biểu thức
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);

                if (c == '(') {
                    stack.push(count);
                    System.out.print(count + " ");
                    count++;
                } else if (c == ')') {
                    System.out.print(stack.pop() + " ");
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}
