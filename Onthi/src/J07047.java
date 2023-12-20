import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class Phong{
    public String loaiphong,tenloai;
    public int dongia;
    public double phi;

    public Phong(String loaiphong, String tenloai, int dongia, double phi) {
        this.loaiphong = loaiphong;
        this.tenloai = tenloai;
        this.dongia = dongia;
        this.phi = phi;
    }
}
class Khach implements Comparable<Khach>{
    public String ma,ten,maphong;
    public Date ngayden,ngaydi;
    public long songay;

    Phong phong;
    public Khach(String ma, String ten, String maphong, Date ngayden, Date ngaydi,Phong phong) {
        this.ma = ma;
        this.ten = ten;
        this.maphong = maphong;
        this.ngayden = ngayden;
        this.ngaydi = ngaydi;
        this.songay=(ngaydi.getTime()-ngayden.getTime())/(1000*60*60*24);
        this.phong=phong;
    }
    public long getSongay()
    {
        long n =  (ngaydi.getTime()-ngayden.getTime())/(1000*60*60*24);
       if (n==0)
       {
           return 1;
       }
       else
       {
           return n;
       }
    }
    public double tinhtien() {
        double tien = phong.dongia*getSongay();
        if(songay>30) tien=tien*0.94;
        else if (songay>=20) tien=tien*0.96;
        else if (songay>=10) tien=tien*0.98;
        double dv= tien*phong.phi;
        double fin=tien+dv;
        return fin;
    }
    @Override
    public int compareTo(Khach other)
    {
        return (int)(other.songay-this.songay);
    }
    @Override
    public String toString()
    {
        return ma+" "+ten+" "+maphong+" "+ songay+" "+String.format("%.2f",tinhtien());
    }
}
 public class J07047 {
     public static void main(String[] args) throws FileNotFoundException, ParseException {
         Scanner sc=new Scanner(new File("Onthi/src/DATA.in"));
         int n= sc.nextInt();
         sc.nextLine();
         ArrayList<Phong> dsp=new ArrayList<>();
         for(int i=0;i<n;i++)
         {
             String[] s=sc.nextLine().split(" ");
             String loai=s[0];
             String ten =s[1];
             int gia=Integer.parseInt(s[2]);
             double dv = Double.parseDouble(s[3]);
             dsp.add(new Phong(loai,ten,gia,dv));
         }
         int m=sc.nextInt();
         sc.nextLine();
         ArrayList<Khach> dskh=new ArrayList<>();
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         for(int i=0;i<m;i++)
         {
             String ma="KH"+String.format("%02d",i+1);
             String ten=sc.nextLine();
             String maphong=sc.nextLine();
             Date ngayden=sdf.parse(sc.nextLine());
             Date ngaydi=sdf.parse(sc.nextLine());
             String loai=maphong.substring(2,3);
             Phong phong=null;
             for(Phong p:dsp)
             {
                 if(p.loaiphong.equals(loai))
                 {

                     phong=p;
                     break;
                 }
             }
             dskh.add(new Khach(ma,ten,maphong,ngayden,ngaydi,phong));
         }
         Collections.sort(dskh);
         for(Khach kh:dskh)
         {
             System.out.println(kh);
         }
     }
}
