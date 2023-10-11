package CodePTIT_Java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Time implements Comparable<Time>{
    public int hour,minute,second;
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    @Override
    public String toString(){
        return hour+" "+minute+" "+second;
    }
    public int compareTo(Time other){
        if(this.hour != other.hour){
            return this.hour - other.hour;
        }
        if(this.minute != other.minute){
            return this.minute - other.minute;
        }
        return this.second - other.second;
    }

}
public class J05033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>(n);
        for (int i=0;i<n;i++)
        {
            int h=sc.nextInt();
            int m=sc.nextInt();
            int s=sc.nextInt();
            Time t = new Time(h,m,s);
            list.add(t);
        }
        Collections.sort(list);
        for(Time t :list)
        {
            System.out.println(t);
        }

    }
}
