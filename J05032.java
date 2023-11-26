package CodePTIT_Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class J05032 {
    public static class Human implements Comparable<Human>{
        String name;
        Date birthday;
        public Human(String name, Date birthday){
            this.name = name;
            this.birthday = birthday;
        }
        @Override
        public int compareTo(Human o) {
            return this.birthday.before(o.birthday) ? -1 : 1;
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        List<Human> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(n-->0){
            String name = sc.next();
            String date = sc.next();
            Date birthday = sdf.parse(date);
            list.add(new Human(name, birthday));
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1).name);
        System.out.println(list.get(0).name);
    }
}
