package CodePTIT_Java;

import java.util.*;

public class J06003 {
    public static class Sinhvien {
        public String masv;
        public String hoten;
        public String sdt;
        public String nhom;

        public Sinhvien(String masv, String hoten, String sdt, String nhom) {
            this.masv = masv;
            this.hoten = hoten;
            this.sdt = sdt;
            this.nhom = nhom;
        }
    }

    public static class Nhom {
        public String manhom;
        public String detai;
        List<Sinhvien> list = new ArrayList<>();

        public Nhom(String manhom, String detai, List<Sinhvien> list) {
            this.manhom = manhom;
            this.detai = detai;
            this.list = list;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t[] = sc.nextLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        List<Nhom> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String msv = sc.nextLine();
            String hoten = sc.nextLine();
            String sdt = sc.nextLine();
            String nhom = sc.nextLine();
            Sinhvien sv = new Sinhvien(msv, hoten, sdt, nhom);
            boolean isExisted = false;
            for (Nhom nh : list) {
                if (nh.manhom.equals(nhom)) {
                    nh.list.add(sv);
                    isExisted = true;
                    break;
                }
            }
            if (!isExisted) {
                List<Sinhvien> svList = new ArrayList<>();
                svList.add(sv);
                Nhom newNhom = new Nhom(nhom, "", svList);
                list.add(newNhom);
            }
        }
        for (int i = 0; i < m; i++) {
            String detai = sc.nextLine();
            list.get(i).detai = detai;
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String nhom = sc.nextLine();
            System.out.println("DANH SACH NHOM " + nhom + ":");
            for (Nhom nh : list) {
                if (nh.manhom.equals(nhom)) {
                    for (Sinhvien sv : nh.list) {
                        System.out.println(sv.masv + " " + sv.hoten + " " + sv.sdt);
                    }
                    System.out.println("Bai tap dang ky: " + nh.detai);
                    break;
                }
            }
        }
    }
}