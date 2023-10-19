package CodePTIT_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Monhoc implements Comparable<Monhoc>{
    private String ten,id;
    private int sotinchi;
    public Monhoc(String id,String ten,int sotinchi){
        this.id = id;
        this.ten = ten;
        this.sotinchi = sotinchi;
    }
    public String getTen() {
        return ten;
    }
    public int compareTo(Monhoc o){
        return this.ten.compareTo(o.getTen());
    }
    @Override
    public String toString(){
        return id+" "+ten+" "+sotinchi;
    }
}
public class J07034 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("MONHOC.in"));
        int n=Integer.parseInt(sc.nextLine());
        List<Monhoc> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id=sc.nextLine();
            String ten=sc.nextLine();
            int sotinchi=Integer.parseInt(sc.nextLine());
            list.add(new Monhoc(id,ten,sotinchi));
        }
        Collections.sort(list);
        for (Monhoc i : list) {
            System.out.println(i);
        }
    }
}
