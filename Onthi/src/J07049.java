import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Sanpham{
    public String ma,ten;
    public long gia;
    public int thoihan;

    public Sanpham(String ma, String ten, long gia, int thoihan) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.thoihan = thoihan;
    }
}
class Khachhang1 implements Comparable<Khachhang1>{
    public String ma,ten,diachi,masp;
    public int soluong;
    public Date ngaymua,ngayhethan;
    Sanpham sp;

    public Khachhang1(String ma, String ten, String diachi, String masp, int soluong, Date ngaymua, Sanpham sp) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.masp = masp;
        this.soluong = soluong;
        this.ngaymua = ngaymua;
        this.sp = sp;
        this.ngayhethan=getNgaygethan();
    }
    public Date getNgaygethan()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ngaymua);
        calendar.add(Calendar.MONTH,sp.thoihan);
        Date res = calendar.getTime();
        return res;
    }
    @Override
    public int compareTo(Khachhang1 o)
    {
        if(this.ngayhethan.equals(o.ngayhethan))
        {
            return this.ma.compareTo(o.ma);
        }
        else
        {
            return this.ngayhethan.compareTo(o.ngayhethan);
        }
    }
    @Override
    public String toString()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        return ma+ " "+ ten+" "+diachi+" "+masp+" "+sp.gia*soluong+" "+sdf.format(ngayhethan);
    }
}
public class J07049 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc=new Scanner(new File("MUAHANG.in"));
        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<Sanpham> dssp=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String ma=sc.nextLine();
            String ten=sc.nextLine();
            long gia=Long.parseLong(sc.nextLine());
            int thoihan=Integer.parseInt(sc.nextLine());
            dssp.add(new Sanpham(ma,ten,gia,thoihan));
        }
        int m=sc.nextInt();
        sc.nextLine();
        ArrayList<Khachhang1> dskh=new ArrayList<>();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        for(int i=0;i<m;i++)
        {
            String ma="KH"+String.format("%02d",i+1);
            String ten=sc.nextLine();
            String diachi=sc.nextLine();
            String masp=sc.nextLine();
            int soluong=Integer.parseInt(sc.nextLine());
            Date ngaymua=sdf.parse(sc.nextLine());
            Sanpham sp=null;
            for(Sanpham s:dssp)
            {
                if(s.ma.equals(masp))
                {
                    sp=s;
                    break;
                }
            }
            dskh.add(new Khachhang1(ma,ten,diachi,masp,soluong,ngaymua,sp));
        }
        Collections.sort(dskh);
        for(Khachhang1 kh:dskh)
        {
            System.out.println(kh);
        }

    }

}
