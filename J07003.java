package CodePTIT_Java;
import java.io.*;
import java.math.BigInteger;

public class J07003 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("DATA.in"));
            String input = br.readLine();
            br.close();
            BigInteger num = new BigInteger(input);
            String s1=num.toString();
            if (s1.length() == 1) {
                System.out.println(s1);
                return;
            }
            while (num.toString().length() > 1) {
                String s=num.toString();
                int l=s.length();
                String half1=s.substring(0,l/2);
                String half2=s.substring(l/2);
                BigInteger n1=new BigInteger(half1);
                BigInteger n2=new BigInteger(half2);
                num=n1.add(n2);
                System.out.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
