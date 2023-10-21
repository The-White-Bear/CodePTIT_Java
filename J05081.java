package CodePTIT_Java;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Product1 implements Comparable<Product1>{
    public static int NUM_PRODUCT=1;
    public String id;
    public String name;
    public String Donvi;
    public int cost;
    public int price;
    public int profit;

    public Product1( String name, String Donvi, int cost, int price){
        this.id = "MH" + String.format("%03d", NUM_PRODUCT++);
        this.name = name;
        this.Donvi = Donvi;
        this.cost = cost;
        this.price = price;
        this.profit = price - cost;
    }
    public int compareTo(Product1 other){
        if( this.profit != other.profit){
            return other.profit - this.profit;
        }
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString(){
        return id + " " + name + " " + Donvi + " " + cost + " " + price + " " + profit;
    }
}
public class J05081 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Product1> list = new ArrayList<>(n);
        for (int i=0;i<n;i++)
        {

            String name = sc.nextLine();
            String Donvi = sc.nextLine();
            int cost =Integer.parseInt(sc.nextLine());
            int price =Integer.parseInt(sc.nextLine());
            Product1 t = new Product1( name, Donvi, cost, price);
            list.add(t);
        }
        Collections.sort(list);
        for(Product1 t :list)
        {
            System.out.println(t);
        }
    }
}
