package CodePTIT_Java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang> {
    private static int counter = 1;
    private String ma;
    private String ten;
    private int dinhMuc;
    private long tienTrongDinhMuc;
    private long tienVuotDinhMuc;
    private long vat;
    private long tongTien;

    public KhachHang(String ten, String loai, int start, int end) {
        this.ma = "KH" + String.format("%02d", counter++);
        this.ten = chuanHoaTen(ten);
        switch (loai) {
            case "A":
                dinhMuc = 100;
                break;
            case "B":
                dinhMuc = 500;
                break;
            case "C":
                dinhMuc = 200;
                break;
        }
        int soDien = end - start;
        tienTrongDinhMuc = Math.min(soDien, dinhMuc) * 450;
        tienVuotDinhMuc = Math.max(0, soDien - dinhMuc) * 1000;
        vat = (long) ( tienVuotDinhMuc * 0.05);
        tongTien = tienTrongDinhMuc + tienVuotDinhMuc + vat;
    }

    private String chuanHoaTen(String ten) {
        String[] words = ten.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)));
            result.append(word.substring(1));
            result.append(" ");
        }
        return result.toString().trim();
    }

    @Override
    public int compareTo(KhachHang o) {
        return Long.compare(o.tongTien, this.tongTien);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tienTrongDinhMuc + " " + tienVuotDinhMuc + " "+vat+ " " + tongTien;
    }
}

public class J07056 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Learning\\CodePTIT_Java\\KHACH.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<KhachHang> danhSachKhachHang = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String ten = sc.nextLine();
            String[] info = sc.nextLine().split(" ");
            String loai = info[0];
            int start = Integer.parseInt(info[1]);
            int end = Integer.parseInt(info[2]);
            danhSachKhachHang.add(new KhachHang(ten, loai, start, end));
        }

        Collections.sort(danhSachKhachHang);

        for (KhachHang khachHang : danhSachKhachHang) {
            System.out.println(khachHang);
        }
    }
}
