package CodePTIT_Java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LoaiPhong implements Comparable<LoaiPhong>{
    public char type;
    public String name;
    public int price;
    public double discount;
    public LoaiPhong(String s){
        String[] tmp = s.split(" ");
        type = tmp[0].charAt(0);
        name = tmp[1];
        price = Integer.parseInt(tmp[2]);
        discount = Double.parseDouble(tmp[3]);
    }
    public int compareTo(LoaiPhong o){
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString(){
        return type + " " + name + " " + price + " " + discount;
    }

}
public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
