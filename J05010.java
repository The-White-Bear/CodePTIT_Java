package CodePTIT_Java;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Item1 implements Comparable<Item1> {

    public static int NUM_ITEM = 1;
    private int id;
    private String  name, type;
    private Float cost, price, profit;

    public Item1(String name, String type, Float cost, Float price) {
        this.id = NUM_ITEM++;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.price = price;
        this.profit = price - cost;
    }

    public float getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + type + " " + String.format("%.2f", profit);
    }

    @Override
    public int compareTo(Item1 other) {
        return -profit.compareTo(other.getProfit());
    }
}

public class J05010 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Item1[] items = new Item1[n];
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String type = sc.nextLine();
            Float cost = Float.parseFloat(sc.nextLine());
            Float price = Float.parseFloat(sc.nextLine());
            items[i] = new Item1(name, type, cost, price);
        }
        Arrays.sort(items);
        for (Item1 i : items) {
            System.out.println(i);
        }
    }
}