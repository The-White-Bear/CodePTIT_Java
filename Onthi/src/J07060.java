import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class Monhoc{
    public  String ma,ten,hinhthuc;

    public Monhoc(String ma, String ten, String hinhthuc) {
        this.ma = ma;
        this.ten = ten;
        this.hinhthuc = hinhthuc;
    }
}
class Cathi{
    public String ma,phong;
    public Date ngaythi,giothi;

    public Cathi(String ma, String phong, Date ngaythi, Date giothi) {
        this.ma = ma;
        this.phong = phong;
        this.ngaythi = ngaythi;
        this.giothi = giothi;
    }
}
class Lichthi implements Comparable<Lichthi>{
    String maca,mamon,manhom,soluong;
    Monhoc mh;
    Cathi ct;

    public Lichthi(String maca, String mamon, String manhom, String soluong, Monhoc mh, Cathi ct) {
        this.maca = maca;
        this.mamon = mamon;
        this.manhom = manhom;
        this.soluong = soluong;
        this.mh = mh;
        this.ct = ct;
    }
    @Override
    public int compareTo(Lichthi other)
    {
        if(this.ct.ngaythi.equals(other.ct.ngaythi))
        {
            if(this.ct.giothi.equals(other.ct.giothi))
            {
                return this.ct.ma.compareTo(other.ct.ma);
            }
            else {
                return this.ct.giothi.compareTo(other.ct.giothi);
            }
        }
        else
        {
            return this.ct.ngaythi.compareTo(other.ct.ngaythi);
        }
    }
    @Override
    public String toString()
    {
        SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm") ;
        return sdf1.format(ct.ngaythi)+" "+sdf2.format(ct.giothi)+" "+ct.phong+" "+mh.ten+" "+manhom+" "+soluong;
    }
}
public class J07060 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc=new Scanner(new File("MONTHI.in"));
        ArrayList<Monhoc> dsmh=new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String ma=sc.nextLine();
            String ten=sc.nextLine();
            String hinhthuc=sc.nextLine();
            dsmh.add(new Monhoc(ma,ten,hinhthuc));
        }
        Scanner sc1=new Scanner(new File("CATHI.in"));
        ArrayList<Cathi> dsct=new ArrayList<>();
        int m=sc1.nextInt();
        sc1.nextLine();
        SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm") ;
        for(int i=0;i<m;i++)
        {
            Date ngaythi= sdf1.parse(sc1.nextLine());
            Date giothi=sdf2.parse(sc1.nextLine());
            String phongthi=sc1.nextLine();
            String maca="C"+String.format("%03d",i+1);
            dsct.add(new Cathi(maca,phongthi,ngaythi,giothi));
        }
        Scanner sc2=new Scanner(new File("LICHTHI.in"));
        ArrayList<Lichthi> dslt=new ArrayList<>();
        int k=sc2.nextInt();
        sc2.nextLine();
        for(int i=0;i<k;i++)
        {

            String maca=sc2.next();
            String mamon=sc2.next();
            String nhom=sc2.next();
            String soluong=sc2.next();
            Monhoc mh=null;
            Cathi ct=null;
            for(int j=0;j<n;j++)
            {
                if(dsmh.get(j).ma.equals(mamon))
                {
                    mh=dsmh.get(j);
                    break;
                }
            }
            for(int j=0;j<m;j++)
            {
                if(dsct.get(j).ma.equals(maca))
                {
                    ct=dsct.get(j);
                    break;
                }
            }
            dslt.add(new Lichthi(maca,mamon,nhom,soluong,mh,ct));
        }
        Collections.sort(dslt);
        for(Lichthi lt:dslt)
        {
            System.out.println(lt);
        }

    }
}
