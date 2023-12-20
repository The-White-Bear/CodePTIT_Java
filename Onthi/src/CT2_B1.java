import java.util.ArrayList;
import java.util.Scanner;

class Nhanvien1 {
    public static int Num=1;
    public String ma,hoten,chucvu;
    public long luongngay,songay,luongthang,thuong,phucap,thucte;

    public Nhanvien1(String hoten,  long luongngay, long songay,String chucvu) {
        this.ma="NV"+String.format("%02d",Num++);
        this.hoten = hoten;
        this.chucvu = chucvu;
        this.luongngay = luongngay;
        this.songay = songay;
        this.luongthang=luongngay*songay;
        this.thuong=getThuong();
        this.phucap=getPhucap();
        this.thucte=this.luongthang+this.thuong+this.phucap;
    }
    public long getThuong()
    {
        if(this.songay>=25)
        {
            return (long)this.luongthang*20/100;
        } else if (this.songay>=22 && this.songay<25) {
            return this.luongthang*10/100;
        }
        else
        {
            return 0;
        }
    }
    public long getPhucap()
    {
        if(this.chucvu.equals("GD"))
        {
            return 250000;
        } else if (this.chucvu.equals("PGD")) {
            return 200000;
        } else if (this.chucvu.equals("TP")) {
            return 180000;
        }
        else
        {
            return 150000;
        }
    }
    @Override
    public String toString()
    {
        return ma+" "+hoten+" "+luongthang+" "+thuong+" "+phucap+ " "+thucte;
    }

}
public class CT2_B1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Nhanvien1> ds= new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        long sum=0;
        for (int i=0;i<n;i++)
        {
            String ten=sc.nextLine();
            long luongngay=Long.parseLong(sc.nextLine());
            long songay=Long.parseLong(sc.nextLine());
            String chucvu=sc.nextLine();
            ds.add(new Nhanvien1(ten,luongngay,songay,chucvu));

        }
        for(Nhanvien1 i : ds)
        {
            System.out.println(i);
            sum+=i.thucte;
        }
        System.out.println("Tong chi phi tien luong: "+sum);
    }
}
