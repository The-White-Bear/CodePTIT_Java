import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class J06003 {
    public static class Nhom
    {
        public ArrayList<Sinhvien> ds;
        public String detai;
        public int nhom;

        public Nhom(int nhom,String detai) {
            this.nhom = nhom;
            this.detai=detai;
            this.ds=new ArrayList<>();
        }
    }
    public static class Sinhvien{
        public  String msv,ten,sdt;
        public int nhom;

        public Sinhvien(String msv, String ten, String sdt, int nhom) {
            this.msv = msv;
            this.ten = ten;
            this.sdt = sdt;
            this.nhom = nhom;
        }
        @Override
        public String toString()
        {
            return msv+" "+ten+" "+sdt;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        ArrayList<Sinhvien> list= new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            String id=sc.nextLine();
            String name=sc.nextLine();
            String phone =sc.nextLine();
            int gr=Integer.parseInt(sc.nextLine());
            list.add(new Sinhvien(id,name,phone,gr));
        }
        ArrayList<Nhom> grlist=new ArrayList<>();
        for (int i=0;i<m;i++)
        {
            String s=sc.nextLine();
            grlist.add(new Nhom(i+1,s));
        }
        for (int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grlist.get(i).nhom==list.get(j).nhom)
                {
                    grlist.get(i).ds.add(list.get(j));
                }
            }
        }
        int q=Integer.parseInt(sc.nextLine());
        while (q-->0)
        {
            int id = sc.nextInt();
            System.out.println("DANH SACH NHOM "+id+":");
            for (int i=0;i<grlist.size();i++)
            {
                if(grlist.get(i).nhom==id)
                {
                    for(int j=0;j<grlist.get(i).ds.size();j++)
                    {
                        System.out.println(grlist.get(i).ds.get(j));
                    }
                    System.out.println("Bai tap dang ky: "+grlist.get(i).detai);
                }
            }
        }

    }
}
