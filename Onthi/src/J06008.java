import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Monhoc3{
    public String mamon,tenmon;
    public float giochuan;
    public Monhoc3(String mamon, String tenmon) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.giochuan=0;
    }
    @Override
    public String toString()
    {
        return tenmon+" "+giochuan;
    }
}
class Giangvien2{
    public String magv,ten;
    ArrayList<Monhoc3> dsmh;
    public float tonggio;
    public Giangvien2(String magv, String ten) {
        this.magv = magv;
        this.ten = ten;
        this.tonggio=0;
        this.dsmh=new ArrayList<>();
    }

}
public class J06008 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        ArrayList<Monhoc3> monhocs=new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String[] s=sc.nextLine().split(" ");
            String ma=s[0] ;
            String ten="";
            for(int j=1;j<s.length;j++)
            {
                ten+=s[j]+" ";
            }
            monhocs.add(new Monhoc3(ma,ten.trim()));
        }
        ArrayList<Giangvien2> giangviens=new ArrayList<>();
        int m=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<m;i++)
        {
            String[] s=sc.nextLine().split(" ");
            String ma=s[0] ;
            String ten="";
            for(int j=1;j<s.length;j++)
            {
                ten+=s[j]+" ";
            }
            giangviens.add(new Giangvien2(ma,ten.trim()));
        }
        int k=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<k;i++) {
            String magv = sc.next();
            String mamon = sc.next();
            float gio = Float.parseFloat(sc.next());
            sc.nextLine();
            Monhoc3 mh = null;
            ArrayList<Monhoc3> dsmh2=new ArrayList<>();
            for (Monhoc3 monhoc : monhocs) {
                if (monhoc.mamon.equals(mamon)) {
                    mh = monhoc;
                    monhoc.giochuan = gio;
                    break;
                }
            }
            for (Giangvien2 giangvien : giangviens) {
                if (giangvien.magv.equals(magv)) {
                    giangvien.dsmh.add(mh);
                    giangvien.tonggio+=gio;
                    break;
                }
            }
        }
        String query=sc.nextLine().trim();
        for(Giangvien2 giangvien2:giangviens)
        {
            if(query.equals(giangvien2.magv))
            {
                System.out.println("Giang vien: "+giangvien2.ten.trim());
                for(Monhoc3 mh:giangvien2.dsmh)
                {
                    System.out.println(mh);
                }
                System.out.print("Tong: "+String.format("%.2f",giangvien2.tonggio));
            }
        }
    }

}
