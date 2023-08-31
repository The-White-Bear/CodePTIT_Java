package CodePTIT_Java;
import java.util.Scanner;
public class J02007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=scanner.nextInt();
            int[] a=new int[n];
            int[] dem=new int[100000];
            for(int j=0;j<n;j++)
            {
                a[j]=scanner.nextInt();
                dem[a[j]]++;
            }
            System.out.println("Test "+i+":");
            for(int j=0;j<n;j++)
            {
                if(dem[a[j]]>=1)
                {
                    System.out.print(a[j]+" xuat hien ");

                    System.out.println(dem[a[j]]+" lan");
                    dem[a[j]]=0;
                }
            }

        }
    }
}
