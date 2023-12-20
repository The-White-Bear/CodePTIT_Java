import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class J07078 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t = sc.nextInt();
        sc.nextLine(); // Đọc dòng mới sau nextInt() để tiếp tục đọc xâu

        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int l1=s1.length();
            int l2=s2.length();
            int idx=0;
            while (idx+l2<=l1)
            {
                if(s1.substring(idx,idx+l2).equals(s2))
                {
                    System.out.print(String.format("%d ",idx+1));
                }
                idx+=1;
            }
            System.out.println();
        }
    }
}
