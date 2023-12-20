import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Sinhvien1 implements Comparable<Sinhvien1>{
    public String ma,ten,sdt;
    public String bt;
    public int manhom;
    Nhom nhom;
    public Sinhvien1(String ma, String ten, String sdt, String bt,int manhom, Nhom nhom) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.bt = bt;
        this.manhom=manhom;
        this.nhom = nhom;
    }
    @Override
    public int compareTo(Sinhvien1 other)
    {
        return this.ma.compareTo(other.ma);
    }
    @Override
    public String toString()
    {
        return ma+" "+ten+" "+sdt+" "+nhom.nhom+" "+bt;
    }
}
class Nhom {
    public String msv;
    public int nhom;
    public Nhom(String msv, int nhom) {
        this.msv = msv;
        this.nhom = nhom;
    }
}

public class J07027 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc2=new Scanner(new File("Onthi/src/BAITAP.in"));  // lấy ds bài tập trước
        ArrayList<String> dsbt=new ArrayList<>();
        int m=sc2.nextInt();
        sc2.nextLine();
        for(int i=0;i<m;i++)
        {
            dsbt.add(sc2.nextLine());
        }
        Scanner sc3=new Scanner(new File("Onthi/src/NHOM.in"));
        Scanner sc1=new Scanner(new File("Onthi/src/SINHVIEN.in"));
        ArrayList<Nhom> dsnhom=new ArrayList<>();
        int n=sc1.nextInt();  // lấy số lượng sinh viên = số lượng dòng trong file nhóm
        sc1.nextLine();
        for(int i=0;i<n;i++)   // lấy danh sách trong file nhóm
        {
            String[] s=sc3.nextLine().split(" ");
            String msv=s[0];
            int nhom = Integer.parseInt(s[1]);
            dsnhom.add(new Nhom(msv,nhom));
        }


        ArrayList<Sinhvien1> dssv = new ArrayList<>();  // lấy dssv
        for(int i=0;i<n;i++)
        {
            String msv=sc1.nextLine();
            String ten=sc1.nextLine();
            String sdt=sc1.nextLine();
            Nhom nhom1=null;
            String baitap="";
            for(Nhom group :dsnhom)
            {
                if(msv.equals(group.msv))
                {
                    nhom1=group;
                    break;
                }
            }
            baitap = dsbt.get(nhom1.nhom-1);
            dssv.add(new Sinhvien1(msv,ten,sdt,baitap,nhom1.nhom,nhom1));

        }
        Collections.sort(dssv);
        for(Sinhvien1 sv:dssv)
        {
            System.out.println(sv);
        }
    }
}
