package CodePTIT_Java;

import java.util.Scanner;

public class J02012 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            int index=i;
            while(index>0&&a[index]<a[index-1])
            {
                int tmp=a[index];
                a[index]=a[index-1];
                a[index-1]=tmp;
                index--;
            }
            System.out.printf("Buoc %d: ",i);
            for(int j=0;j<=i;j++)
            {
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }

    }
}
