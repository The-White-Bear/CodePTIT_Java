package CodePTIT_Java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class SinhVien4 implements Comparable<SinhVien4>{
    public static int Num=0;
    public String masv;
    public String hoten;
    public String lop;
    public Date ngaysinh;
    public float gpa;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public SinhVien4( String hoten, String lop, Date ngaysinh, float gpa) {
        this.masv ="B20DCCN"+String.format("%03d", ++Num);
        this.hoten =normalName(hoten);
        this.lop = lop;
        this.ngaysinh = ngaysinh;
        this.gpa = gpa;

    }
    public String normalName(String name){
        name = name.trim().toLowerCase();
        String[] a = name.trim().split("\\s+");
        for (int i = 0; i < a.length; i++) {
            a[i] = Character.toString(a[i].charAt(0)).toUpperCase() + a[i].substring(1);
        }
        return String.join(" ", a);
    }
    @Override
    public String toString() {
        return masv+" "+hoten+" "+lop+" "+sdf.format(ngaysinh)+" "+String.format("%.2f", gpa);
    }
    @Override
    public int compareTo(SinhVien4 o) {
        if(this.gpa > o.gpa) return -1;
        else if(this.gpa < o.gpa) return 1;
        else return this.hoten.compareTo(o.hoten);
    }
}

public class J05005 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<SinhVien4> list = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            String hoten = scanner.nextLine();
            String lop = scanner.nextLine();
            Date ngaysinh = sdf.parse(scanner.nextLine());
            float gpa = Float.parseFloat(scanner.nextLine());
            SinhVien4 sv = new SinhVien4(hoten, lop, ngaysinh, gpa);
            list.add(sv);
        }
        Collections.sort(list);
        for (SinhVien4 sv : list) {
            System.out.println(sv);
        }

    }
}
