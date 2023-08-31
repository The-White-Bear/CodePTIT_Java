package CodePTIT_Java;
import java.util.*;
public class J02004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n=scanner.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            if(check(a,n))
            {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }

    }
    public static boolean check(int[] a, int n){
        for(int i=0;i<=n/2;i++)
        {
            if(a[i]!=a[n-i-1])
            {
                return false;
            }
        }
        return true;
    }
}
