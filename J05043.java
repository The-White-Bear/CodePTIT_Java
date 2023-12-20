package CodePTIT_Java;

import java.util.Scanner;

public class J05043 {
    public static class Nhanvien {
        String maNV;
        String hoTen;
        String chucVu;
        int luongCoBan;
        int soNgayCong;
        int phuCap;
        int luongChinh;
        int tamUng;
        int conLai;

        public Nhanvien(String maNV, String hoTen, String chucVu, int luongCoBan, int soNgayCong) {
            this.maNV = maNV;
            this.hoTen = hoTen;
            this.chucVu = chucVu;
            this.luongCoBan = luongCoBan;
            this.soNgayCong = soNgayCong;
            this.phuCap = getPhuCap(chucVu);
            this.luongChinh = tinhLuong();
            this.tamUng = getTamUng();
            this.conLai = (tinhLuong() + phuCap) - tamUng;
        }

        private int tinhLuong() {
            return luongCoBan * soNgayCong;
        }

        private int getPhuCap(String chucVu) {
            switch (chucVu) {
                case "GD":
                    return 500;
                case "PGD":
                    return 400;
                case "TP":
                    return 300;
                case "KT":
                    return 250;
                default:
                    return 100;
            }
        }

        private int getTamUng() {
            int luong = tinhLuong() + getPhuCap(chucVu);
            if (luong * 2 / 3 >= 25000) {
                return 25000;
            } else {
                return Math.round(luong * 2 / 3 / 1000) * 1000; // Làm tròn đến hàng ngàn
            }
        }

        public String toString() {
            return maNV + " " + hoTen + " " + phuCap + " " + tinhLuong() + " " + tamUng + " " + (tinhLuong() + phuCap - tamUng);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Nhanvien[] nhanViens = new Nhanvien[n];

        for (int i = 0; i < n; i++) {
            String hoTen = scanner.nextLine();
            String chucVu = scanner.nextLine();
            int luongCoBan = Integer.parseInt(scanner.nextLine());
            int soNgayCong = Integer.parseInt(scanner.nextLine());
            String maNV = "NV" + String.format("%02d", i + 1);

            nhanViens[i] = new Nhanvien(maNV, hoTen, chucVu, luongCoBan, soNgayCong);
        }

        for (Nhanvien nhanVien : nhanViens) {
            System.out.println(nhanVien.toString());
        }

        scanner.close();
    }
}
