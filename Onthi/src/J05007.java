import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class J05007 {
    public static class Nhanvien implements Comparable<Nhanvien>{
        public  String id,ten,gt,diachi,mst;
        public Date ngaysinh,ngayky;
        public static int Num=1;

        public Nhanvien(String ten, String gt,Date ngaysinh,String diachi, String mst, Date ngayky) {
            this.id = String.format("%05d",Num++);
            this.ten = ten;
            this.gt=gt;
            this.diachi = diachi;
            this.mst = mst;
            this.ngaysinh = ngaysinh;
            this.ngayky = ngayky;
        }
        @Override
        public String toString()
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return id+" "+ten+" "+gt+" "+sdf.format(ngaysinh)+" "+diachi+" "+ mst+ " "+sdf.format(ngayky);
        }
        @Override
        public int compareTo(Nhanvien other)
        {
            if(this.ngaysinh.after(other.ngaysinh))
            {
                return 1;
            } else if (this.ngaysinh.before(other.ngaysinh)) {
                return -1;
            }
            else {
                return this.ten.compareTo(other.ten);
            }
        }

    }

    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        ArrayList<Nhanvien> list = new ArrayList<>();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        while (t-->0)
        {
            String ten=sc.nextLine();
            String gt=sc.nextLine();
            String s=sc.nextLine();
            Date ngaysinh=sdf.parse(s);
            String dc=sc.nextLine();
            String mst=sc.nextLine();
            String s2=sc.nextLine();
            Date ngayky = sdf.parse(s2);
            list.add(new Nhanvien(ten,gt,ngaysinh,dc,mst,ngayky));
        }
        Collections.sort(list);
        for(Nhanvien nv:list){
            System.out.println(nv);
        }
    }
}
