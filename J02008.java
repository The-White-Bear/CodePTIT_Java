package CodePTIT_Java;

import java.util.Scanner;

public class J02008 {
    public static Scanner scanner=new Scanner(System.in);
    public static long gcd(long a,long b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static long lcm(long a,long b)
    {
        return (a*b)/gcd(a,b);
    }

    public static void main(String[] args) {
        int t=scanner.nextInt();
        while(t-- >0)
        {
            int n=scanner.nextInt();
            long res=1;
            for(int i=2;i<=n;i++)
            {
                res=lcm(res,i);
            }
            System.out.println(res);
        }
    }
}
