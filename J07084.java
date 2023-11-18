package CodePTIT_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Online implements Comparable<Online>{
    String name;
    Date start,end;
    public Online(String name,String start,String end) throws ParseException {
        this.name = name;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.start = sdf.parse(start);
        this.end = sdf.parse(end);
    }
    public long Cal_Time(){
        return (end.getTime()-start.getTime())/(60*1000);
    }
    @Override
    public int compareTo(Online o) {
        int compare = Long.compare(o.Cal_Time(),this.Cal_Time());
        if(compare != 0){
            return compare;
        }
        return this.name.compareTo(o.name);
    }
}
public class J07084 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Online> list = new ArrayList<>();
        while(n-->0){
            String name = sc.nextLine();
            String start = sc.nextLine();
            String end = sc.nextLine();
            list.add(new Online(name,start,end));
        }
        Collections.sort(list);
        for (Online online : list) {
            System.out.println(online.name + " " + online.Cal_Time());
        }

    }
}

