package CodePTIT_Java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05029{
    public static class Company implements Comparable<Company>
    {
        public String id,name;
        public int number;
        public Company(String id, String name, int number)
        {
            this.id = id;
            this.name = name;
            this.number = number;
        }
        @Override
        public int compareTo(Company o)
        {
            if(this.number!=o.number)
            {
                return o.number-this.number;
            }
            return this.id.compareTo(o.id);
        }
        @Override
        public String toString()
        {
            return id+" "+name+" "+number;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Company> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int number = Integer.parseInt(sc.nextLine());
            list.add(new Company(id, name, number));
        }
        Collections.sort(list);
        int q=sc.nextInt();
        sc.nextLine();
        while (q-->0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU "+a+" DEN "+b+" SINH VIEN:");
            for(Company x:list)
            {
                if(x.number>=a&&x.number<=b)
                {
                    System.out.println(x);
                }
            }
        }

    }
}
