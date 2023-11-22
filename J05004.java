package CodePTIT_Java;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class SinhVien3 {
    public static int Num=0;
    public String masv;
    public String hoten;
    public String lop;
    public Date ngaysinh;
    public float gpa;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public SinhVien3( String hoten, String lop, Date ngaysinh, float gpa) {
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
}

public class J05004 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<SinhVien3> list = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            String hoten = scanner.nextLine();
            String lop = scanner.nextLine();
            Date ngaysinh = sdf.parse(scanner.nextLine());
            float gpa = Float.parseFloat(scanner.nextLine());
            SinhVien3 sv = new SinhVien3(hoten, lop, ngaysinh, gpa);
            list.add(sv);
        }
        for (SinhVien3 sv : list) {
            System.out.println(sv);
        }

    }
}
