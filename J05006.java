package CodePTIT_Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class NhanVien1 {
    private static int nextMaNV = 1;

    private String maNV;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String maSoThue;
    private Date ngayKyHopDong;

    public NhanVien1(String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String maSoThue, Date ngayKyHopDong) {
        this.maNV = String.format("%05d", nextMaNV++);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKyHopDong = ngayKyHopDong;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return maNV + " " + hoTen + " " + gioiTinh + " " + sdf.format(ngaySinh) + " " + diaChi + " " + maSoThue + " " + sdf.format(ngayKyHopDong);
    }
}

public class J05006 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        List<NhanVien1> danhSachNV = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        for (int i = 0; i < n; i++) {
            String hoTen = scanner.nextLine();
            String gioiTinh = scanner.nextLine();
            Date ngaySinh = sdf.parse(scanner.nextLine());
            String diaChi = scanner.nextLine();
            String maSoThue = scanner.nextLine();
            Date ngayKyHopDong = sdf.parse(scanner.nextLine());
            danhSachNV.add(new NhanVien1(hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKyHopDong));
        }

        for (NhanVien1 nv : danhSachNV) {
            System.out.println(nv);
        }
    }
}
