package CodePTIT_Java;

import java.util.Scanner;

public class J02010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            int check=1;
           for(int j=i+1;j<n;j++)
           {
               if(a[i]>a[j])
               {
                   check=0;
                   int temp=a[i];
                   a[i]=a[j];
                   a[j]=temp;
               }
           }
           if(check==1)
           {
               break;
           }
            System.out.printf("Buoc %d: ", i + 1);
           for(int j=0;j<n;j++)
           {
               System.out.print(a[j]+" ");
           }
           System.out.println();

        }
    }
}
