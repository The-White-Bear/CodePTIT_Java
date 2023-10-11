package CodePTIT_Java;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Product implements Comparable<Product>{
    public static int NUM_PRODUCT=1;
    public String id;
    public String name;
    public String Donvi;
    public int cost;
    public int price;
    public int profit;

    public Product( String name, String Donvi, int cost, int price){
        this.id = "MH" + String.format("%03d", NUM_PRODUCT++);
        this.name = name;
        this.Donvi = Donvi;
        this.cost = cost;
        this.price = price;
        this.profit = price - cost;
    }
    public int compareTo(Product other){
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
        List<Product> list = new ArrayList<>(n);
        for (int i=0;i<n;i++)
        {

            String name = sc.nextLine();
            String Donvi = sc.nextLine();
            int cost =Integer.parseInt(sc.nextLine());
            int price =Integer.parseInt(sc.nextLine());
            Product t = new Product( name, Donvi, cost, price);
            list.add(t);
        }
        Collections.sort(list);
        for(Product t :list)
        {
            System.out.println(t);
        }
    }
}
