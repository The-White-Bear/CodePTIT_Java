import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NhanVien {
    public String ten, gt, ngaySinh, diaChi, maMatHang;

    public NhanVien(String ten, String gt, String ngaySinh, String diaChi, String maMatHang) {
        this.ten = ten;
        this.gt = gt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maMatHang = maMatHang;
    }
}

class KhachHang {
    public String ma, ten, gt, ngaySinh, diaChi;

    public KhachHang(String ma, String ten, String gt, String ngaySinh, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.gt = gt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
}

class MatHang {
    public String ma, tenHang, donViTinh;
    public long giaMua, giaBan;

    public MatHang(String ma, String tenHang, String donViTinh, long giaMua, long giaBan) {
        this.ma = ma;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
}

class HoaDon {
    public String maHoaDon, maKhachHang, maMatHang;
    public NhanVien nhanVien;
    public KhachHang khachHang;
    public MatHang matHang;
    public long soLuong, thanhTien;

    public HoaDon(String maHoaDon, String maKhachHang, String maMatHang, NhanVien nhanVien, KhachHang khachHang, MatHang matHang, long soLuong) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maMatHang = maMatHang;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
        this.thanhTien = getThanhTien();
    }

    public long getThanhTien() {
        return soLuong * matHang.giaBan;
    }

    @Override
    public String toString() {
        return maHoaDon + " " + khachHang.ten + " " + khachHang.diaChi + " " + matHang.tenHang + " " + matHang.donViTinh + " " +
                nhanVien.ten + " " + nhanVien.diaChi + " " + matHang.giaMua + " " + matHang.giaBan + " " + soLuong + " " + thanhTien;
    }
}

public class CT2_B5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        sc.nextLine();
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String gt = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            String maMatHang = sc.nextLine();
            danhSachNhanVien.add(new NhanVien(ten, gt, ngaySinh, diaChi, maMatHang));
        }

        long m = sc.nextLong();
        sc.nextLine();
        List<KhachHang> danhSachKhachHang = new ArrayList<>();
        for (long i = 0; i < m; i++) {
            String ma = "KH" + String.format("%03d", i + 1);
            String ten = sc.nextLine();
            String gt = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            danhSachKhachHang.add(new KhachHang(ma, ten, gt, ngaySinh, diaChi));
        }

        long p = sc.nextLong();
        sc.nextLine();
        List<MatHang> danhSachMatHang = new ArrayList<>();
        for (long i = 0; i < p; i++) {
            String ma = "MH" + String.format("%03d", i + 1);
            String tenHang = sc.nextLine();
            String donViTinh = sc.nextLine();
            long giaMua = Long.parseLong(sc.nextLine());
            long giaBan = Long.parseLong(sc.nextLine());

            danhSachMatHang.add(new MatHang(ma, tenHang, donViTinh, giaMua, giaBan));
        }

        long q = sc.nextLong();
        sc.nextLine();
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        for (long i = 0; i < q; i++) {
            String maHoaDon = "HD" + String.format("%03d", i + 1);
            String maKhachHang = sc.next();
            String maMatHang = sc.next();
            long soLuong = sc.nextLong();
            KhachHang khachHang = null;
            MatHang matHang = null;
            NhanVien nhanVien = null;

            for (KhachHang kh : danhSachKhachHang) {
                if (kh.ma.equals(maKhachHang)) {
                    khachHang = kh;
                    break;
                }
            }

            for (MatHang mat : danhSachMatHang) {
                if (mat.ma.equals(maMatHang)) {
                    matHang = mat;
                    break;
                }
            }

            for (NhanVien nv : danhSachNhanVien) {
                if (nv.maMatHang.equals(maMatHang)) {
                    nhanVien = nv;
                    break;
                }
            }

            danhSachHoaDon.add(new HoaDon(maHoaDon, maKhachHang, maMatHang, nhanVien, khachHang, matHang, soLuong));
        }
        for (HoaDon hoaDon : danhSachHoaDon) {
            System.out.println(hoaDon);
        }
    }
}
