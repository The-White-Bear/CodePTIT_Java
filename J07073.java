package CodePTIT_Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MonHoc1 implements Comparable<MonHoc1> {
    public String maMonHoc;
    public String tenMonHoc;
    public int soTinChi;
    public String hinhThucLyThuyet;
    public String hinhThucThucHanh;

    public MonHoc1(String maMonHoc, String tenMonHoc, int soTinChi, String hinhThucLyThuyet, String hinhThucThucHanh) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
        this.hinhThucLyThuyet = hinhThucLyThuyet;
        this.hinhThucThucHanh = hinhThucThucHanh;
    }

    @Override
    public int compareTo(MonHoc1 o) {
        return this.maMonHoc.compareTo(o.maMonHoc);
    }
}

public class J07073 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("MONHOC.in"));
            int n = Integer.parseInt(br.readLine()); // Số môn học
            List<MonHoc1> danhSachMonHoc = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String maMonHoc = br.readLine();
                String tenMonHoc = br.readLine();
                int soTinChi = Integer.parseInt(br.readLine());
                String hinhThucLyThuyet = br.readLine();
                String hinhThucThucHanh = br.readLine();

                danhSachMonHoc.add(new MonHoc1(maMonHoc, tenMonHoc, soTinChi, hinhThucLyThuyet, hinhThucThucHanh));
            }
            br.close();

            // Lọc và sắp xếp danh sách các môn thực hành trực tuyến
            List<MonHoc1> monHocThucHanhTrucTuyen = new ArrayList<>();
            for (MonHoc1 monHoc : danhSachMonHoc) {
                if (!"Truc tiep".equals(monHoc.hinhThucThucHanh)) {
                    monHocThucHanhTrucTuyen.add(monHoc);
                }
            }
            Collections.sort(monHocThucHanhTrucTuyen);

            // In ra màn hình
            for (MonHoc1 monHoc : monHocThucHanhTrucTuyen) {
                System.out.println(monHoc.maMonHoc + " " + monHoc.tenMonHoc + " " + monHoc.soTinChi + " " +
                        monHoc.hinhThucLyThuyet + " " + monHoc.hinhThucThucHanh);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
