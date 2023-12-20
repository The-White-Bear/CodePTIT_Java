import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07018 {
    public static class Sinhvien{
        public String msv,ten,lop,ngaysinh;
        public float diem;

        public Sinhvien(String msv, String ten,String lop, String ngaysinh, float diem) {
            this.msv = msv;
            this.ten = chuanhoaten(ten);
            this.lop=lop;
            this.ngaysinh = chuanhoasn(ngaysinh);
            this.diem = diem;
        }
        public String chuanhoaten(String s)
        {
            s=s.replaceAll("\\s+"," ").trim();
            String[] words=s.split(" ");
            StringBuilder fullname=new StringBuilder();
            for(String  word:words)
            {
                String tmp =word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase();
                fullname.append(tmp).append(" ");
            }
            return fullname.toString().trim();

        }
        public String chuanhoasn(String s)
        {
            String[] words=  s.split("/");
            String sn="";
            if(words[0].length()<2)
            {
                words[0]="0"+ words[0];
            }
            if(words[1].length()<2)
            {
                words[1]="0"+ words[1];
            }
            return String.join("/",words);
        }
        @Override
        public String toString()
        {
            return String.format("%s %s %s %s %.2f",msv,ten,lop,ngaysinh,diem );
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("SINHVIEN.in"));
        int t=sc.nextInt();
        sc.nextLine();
        ArrayList<Sinhvien> ds=new ArrayList<>();
        for(int i=0;i<t;i++)
        {
            String msv = "B20DCCN"+String.format("%03d",i+1);
            String ten=sc.nextLine();
            String lop=sc.nextLine();
            String sn=sc.nextLine();
            float diem=Float.parseFloat(sc.nextLine());
            ds.add(new Sinhvien(msv,ten,lop,sn,diem));
        }
        for(Sinhvien sv:ds)
        {
            System.out.println(sv);
        }
    }
}
