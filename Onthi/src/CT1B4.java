import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class SinhVien {
    public static int Num=1;
    String ma_sv,id;
    String ho_ten;
    Date ngay_sinh;
    String que_quan;

    SinhVien(String ma_sv, String ho_ten, Date ngay_sinh, String que_quan) {
        this.ma_sv = ma_sv;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.que_quan = que_quan;
        this.id="SV"+String.format("%03d",Num++);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return id+" "+ma_sv + " " + ho_ten + " " + sdf.format(ngay_sinh) + " " + que_quan;
    }
}

public class CT1B4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma_sv = scanner.nextLine().trim();
            String ten = chuanHoaTen(scanner.nextLine().trim());
            Date ngay_sinh = chuanHoaNgaySinh(scanner.nextLine().trim());
            String que_quan = scanner.nextLine().trim();
            danhSachSinhVien.add(new SinhVien(ma_sv, ten, ngay_sinh, que_quan));
        }
        int q=Integer.parseInt(scanner.nextLine());
        while(q-->0){
            String s=scanner.nextLine();
            String[] arr=s.split(" ");
            if(arr[0].equals("1")){
                String tinh="";
                for (int i=1;i<arr.length;i++){
                    tinh+=arr[i]+" ";
                }
                tinh=tinh.trim();
                lietKeSinhVienTheoTinh(danhSachSinhVien, tinh);
            } else if (arr[0].equals("2")) {
                lietKeSinhVienTheoNamSinh(danhSachSinhVien, Integer.parseInt(arr[1]));
            } else if (arr[0].equals("3")) {
                lietKeSinhVienTheoMaSv(danhSachSinhVien);
            }
            else {
                lietKeSinhVienTheoTenGanDung(danhSachSinhVien, arr[1]);
            }
        }
    }

    private static String chuanHoaTen(String ten) {
        StringBuilder res = new StringBuilder();
        ten = ten.trim();
        String[] arr = ten.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            String normalizedWord = arr[i].toLowerCase();
            normalizedWord = Character.toUpperCase(normalizedWord.charAt(0)) + normalizedWord.substring(1);
            res.append(normalizedWord);
            if (i < arr.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }


    private static Date chuanHoaNgaySinh(String ngay_sinh) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(ngay_sinh);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void lietKeSinhVienTheoTinh(ArrayList<SinhVien> danhSachSinhVien, String tinh) {
        ArrayList<SinhVien> result = new ArrayList<>();
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.que_quan.equalsIgnoreCase(tinh)) {
                result.add(sv);
            }
        }

        Collections.sort(result, Comparator.comparing(sv -> sv.ho_ten));

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (SinhVien sv : result) {
                System.out.println(sv);
            }
        }
        System.out.println("");
    }

    private static void lietKeSinhVienTheoNamSinh(ArrayList<SinhVien> danhSachSinhVien, int nam) {
        ArrayList<SinhVien> result = new ArrayList<>();
        for (SinhVien sv : danhSachSinhVien) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sv.ngay_sinh);
            if (cal.get(Calendar.YEAR) == nam) {
                result.add(sv);
            }
        }

        Collections.sort(result, Comparator.comparing(sv -> sv.ngay_sinh));

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int i = result.size() - 1; i >= 0; i--) {
                System.out.println(result.get(i));
            }
        }
        System.out.println("");
    }

    private static void lietKeSinhVienTheoMaSv(ArrayList<SinhVien> danhSachSinhVien) {
        Collections.sort(danhSachSinhVien, Comparator.comparing(sv -> sv.ma_sv));

        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv);
        }
        System.out.println("");
    }

    private static void lietKeSinhVienTheoTenGanDung(ArrayList<SinhVien> danhSachSinhVien, String keyword) {
        ArrayList<SinhVien> result = new ArrayList<>();
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.ho_ten.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(sv);
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (SinhVien sv : result) {
                System.out.println(sv);
            }
        }
        System.out.println("");
    }
}
