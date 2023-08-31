package CodePTIT_Java;

import java.util.Scanner;

public class J03006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số bộ test
        int soBoTest = scanner.nextInt();

        for (int i = 0; i < soBoTest; i++) {
            String s = scanner.next();
            String ketQua = kiemTraSoDep(s);
            System.out.println(ketQua);
        }
    }

    public static String kiemTraSoDep(String s) {
        boolean isThuannghich = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                isThuannghich = false;
                break;
            }
        }
        boolean isToanChan = true;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit % 2 != 0) {
                isToanChan = false;
                break;
            }
        }
        if (isThuannghich && isToanChan) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
