import java.util.Scanner;

public class J02037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t--> 0) {
            String[] s= scanner.nextLine().trim().split("\\s+");
            int count_odd=0;
            int count_even=0;
            int l= s.length;
            for (int i=0;i<s.length;i++)
            {
                if(Integer.parseInt(s[i])%2==0)
                {
                    count_even++;
                }
                else {
                    count_odd++;
                }
            }
            if((l%2==0&&count_even>count_odd)||(l%2==1&&count_odd>count_even))
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}