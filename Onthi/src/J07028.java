import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Monhoc2{
    public String mamon,tenmon;
    public float giochuan;
    public Monhoc2(String mamon, String tenmon) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.giochuan=0;
    }
}
class Giangvien{
    public String magv,ten;
    ArrayList<Monhoc2> dsmh;
    public float tonggio;
    public Giangvien(String magv, String ten) {
        this.magv = magv;
        this.ten = ten;
        this.tonggio=0;
        this.dsmh=new ArrayList<>();
    }
    public float getTonggio()
    {
        float sum=0;
        for (Monhoc2 mh:dsmh)
        {
            sum+=mh.giochuan;
        }
        return sum;
    }
    @Override
    public String toString()
    {
        return ten+" "+String.format("%.2f",tonggio);
    }
}
public class J07028 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1=new Scanner(new File("MONHOC.in"));
        ArrayList<Monhoc2> monhocs=new ArrayList<>();
        int n=sc1.nextInt();
        sc1.nextLine();
        for(int i=0;i<n;i++)
        {
            String ma= sc1.next();
            String ten=sc1.next();
            monhocs.add(new Monhoc2(ma,ten));
        }
        Scanner sc2=new Scanner(new File("GIANGVIEN.in"));
        ArrayList<Giangvien> giangviens=new ArrayList<>();
        int m=sc2.nextInt();
        sc2.nextLine();
        for(int i=0;i<m;i++)
        {
            String[] s=sc2.nextLine().split(" ");
            String ma=s[0] ;
            String ten="";
            for(int j=1;j<s.length;j++)
            {
                ten+=s[j]+" ";

            }

            giangviens.add(new Giangvien(ma,ten.trim()));
        }
        Scanner sc3=new Scanner(new File("GIOCHUAN.in"));
        int k=sc3.nextInt();
        for(int i=0;i<k;i++) {
            String magv = sc3.next();
            String mamon = sc3.next();
            float gio = Float.parseFloat(sc3.next());
            Monhoc2 mh = null;
            Giangvien gv = null;
            for (Monhoc2 monhoc : monhocs) {
                if (monhoc.mamon.equals(mamon)) {
                    mh = monhoc;
                    monhoc.giochuan = gio;
                    break;
                }
            }
            for (Giangvien giangvien : giangviens) {
                if (giangvien.magv.equals(magv)) {
                    giangvien.tonggio+=gio;
                    break;
                }
            }
        }
        for(Giangvien giangvien:giangviens)
        {
            System.out.println(giangvien);
        }
    }

}
