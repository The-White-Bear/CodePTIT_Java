package CodePTIT_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class ThiSinh1 implements Comparable<ThiSinh1> {
    private static int nextMaTS = 1;
    private int maTS;
    private String tenTS;
    private String ngaySinh;
    private float diemMon1;
    private float diemMon2;
    private float diemMon3;

    public ThiSinh1(String tenTS, String ngaySinh, float diemMon1, float diemMon2, float diemMon3) {
        this.maTS = nextMaTS++;
        this.tenTS = tenTS;
        this.ngaySinh = ngaySinh;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }
    public float getDiemTong() {
        return diemMon1 + diemMon2 + diemMon3;
    }
    @Override
    public String toString() {
        return maTS + " " + tenTS + " " + ngaySinh + " " + String.format("%.1f", getDiemTong());
    }
    @Override
    public int compareTo(ThiSinh1 o) {
        if (this.getDiemTong()!=o.getDiemTong())
            return (int) (o.getDiemTong() - this.getDiemTong());
        else
            if (this.maTS < o.maTS)
                return -1;
            else
                return 1;
    }

}
public class J05009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<ThiSinh1> danhSachTS = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String tenTS = scanner.nextLine();
            String ngaySinh = scanner.nextLine();
            float diemMon1 = scanner.nextFloat();
            float diemMon2 = scanner.nextFloat();
            float diemMon3 = scanner.nextFloat();
            scanner.nextLine();
            danhSachTS.add(new ThiSinh1(tenTS, ngaySinh, diemMon1, diemMon2, diemMon3));
        }
        Collections.sort(danhSachTS);
        float diemCaoNhat = danhSachTS.get(0).getDiemTong();
        for (ThiSinh1 ts : danhSachTS) {
            if (ts.getDiemTong() == diemCaoNhat) {
                System.out.println(ts);
            } else {
                break;
            }
        }
    }
}