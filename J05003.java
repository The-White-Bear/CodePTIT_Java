package CodePTIT_Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class SinhVien2 {
    public static int Num=0;
    public String masv;
    public String hoten;
    public String lop;
    public Date ngaysinh;
    public float gpa;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public SinhVien2( String hoten, String lop, Date ngaysinh, float gpa) {
        this.masv ="B20DCCN"+String.format("%03d", ++Num);
        this.hoten = hoten;
        this.lop = lop;
        this.ngaysinh = ngaysinh;
        this.gpa = gpa;

    }
    @Override
    public String toString() {
        return masv+" "+hoten+" "+lop+" "+sdf.format(ngaysinh)+" "+String.format("%.2f", gpa);
    }
}

public class J05003 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<SinhVien2> list = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            String hoten = scanner.nextLine();
            String lop = scanner.nextLine();
            Date ngaysinh = sdf.parse(scanner.nextLine());
            float gpa = Float.parseFloat(scanner.nextLine());
            SinhVien2 sv = new SinhVien2(hoten, lop, ngaysinh, gpa);
            list.add(sv);
        }
        for (SinhVien2 sv : list) {
            System.out.println(sv);
        }

    }
}
