package CodePTIT_Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05020 {
    static class SinhVien {
        String maSV, hoTen, lop, email;

        public SinhVien(String maSV, String hoTen, String lop, String email) {
            this.maSV = maSV;
            this.hoTen = hoTen;
            this.lop = lop;
            this.email = email;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] dsSinhVien = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            String maSV = sc.nextLine();
            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();

            dsSinhVien[i] = new SinhVien(maSV, hoTen, lop, email);
        }
        Arrays.sort(dsSinhVien, Comparator.comparing((SinhVien sv) -> sv.lop).thenComparing(sv -> sv.maSV));
        for (SinhVien sv : dsSinhVien) {
            System.out.println(sv.maSV + "  " + sv.hoTen + "  " + sv.lop + "  " + sv.email);
        }
    }
}
