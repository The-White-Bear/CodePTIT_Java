package CodePTIT_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.round;

public class J05036 {
    public static class Item implements Comparable<Item> {
        public String id, name, unit;
        public double quantity, price;

        public Item(String name, String unit, double price, double quantity) {
            this.id ="MH"+String.format("%02d", Num++);
            this.name = name;
            this.unit = unit;
            this.quantity = quantity;
            this.price = price;
        }

        public long phiVanChuyen(){
            return Math.round(price * quantity * 0.05);
        }

        public long thanhTien(){
            return Math.round(price * quantity + phiVanChuyen());
        }

        public long giaBan(){
            return Math.round(thanhTien() * 1.02);
        }

        @Override
        public int compareTo(Item o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString(){
            return id + " " + name + " " + unit + " " + phiVanChuyen() + " " + thanhTien() + " " + giaBan();
        }
    }

    public static int Num = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        List<Item> list = new ArrayList<>();
        while (t-- > 0) {
            String name = sc.nextLine();
            String unit = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            double quantity = Double.parseDouble(sc.nextLine());
            list.add(new Item(name, unit, price, quantity));
        }
//        Collections.sort(list);
        for (Item item : list) {
            System.out.println(item);
        }
    }
}
