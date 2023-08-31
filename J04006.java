package CodePTIT_Java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private String lop;
    private Date ngaySinh;
    private float diemGPA;

    public SinhVien() {
        this.maSV = "B20DCCN001";
        this.hoTen = "";
        this.lop = "";
        this.ngaySinh = new Date();
        this.diemGPA = 0.2f;
    }

    public void nhapThongTin() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        this.hoTen = scanner.nextLine();
        this.lop = scanner.nextLine();
        String ngaySinhStr = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.ngaySinh = dateFormat.parse(ngaySinhStr);

        this.diemGPA = scanner.nextFloat();

        scanner.close();
    }

    public void inThongTin() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = dateFormat.format(this.ngaySinh);
        System.out.println(this.maSV + " " + this.hoTen + " " + this.lop + " " + ngaySinhStr + " " + String.format("%.2f", this.diemGPA));
    }

    public static void main(String[] args) throws ParseException {
        SinhVien sv = new SinhVien();
        sv.nhapThongTin();
        sv.inThongTin();
    }
}