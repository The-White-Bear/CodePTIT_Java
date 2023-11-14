package CodePTIT_Java;
import java.util.*;
import java.io.*;

class MonHoc {
    String maMon;
    String tenMon;
    String hinhThucThi;

    MonHoc(String maMon, String tenMon, String hinhThucThi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThucThi = hinhThucThi;
    }
}

public class J07058 {
    public static void main(String[] args) throws IOException {
        List<MonHoc> monHocs = new ArrayList<>();

        File file = new File("MONHOC.in");
        Scanner scanner = new Scanner(file);

        int soMonHoc = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soMonHoc; i++) {
            String maMon = scanner.nextLine();
            String tenMon = scanner.nextLine();
            String hinhThucThi = scanner.nextLine();

            MonHoc monHoc = new MonHoc(maMon, tenMon, hinhThucThi);
            monHocs.add(monHoc);
        }

        Collections.sort(monHocs, (a, b) -> a.maMon.compareTo(b.maMon));

        for (MonHoc monHoc : monHocs) {
            System.out.println( monHoc.maMon + " "  + monHoc.tenMon + " " +monHoc.hinhThucThi);

        }
    }
}
