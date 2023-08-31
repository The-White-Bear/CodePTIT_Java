package CodePTIT_Java;

import java.util.Scanner;

public class J03007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        int sum=0;
        boolean checksum = true;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            sum+=digit;
        }
        if(sum%10!=0) {
            checksum = false;
        }
        boolean check2=true;
        if(s.charAt(0)=='8'&&s.charAt(s.length()-1)=='8')
        {
            check2=true;
        }
        else
        {
            check2=false;
        }
        if (isThuannghich && checksum && check2) {
            return "YES";
        } else {
            return "NO";
        }


    }
}
