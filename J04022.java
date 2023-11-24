package CodePTIT_Java;

import java.util.*;
class WordSet1 {
    TreeSet<String> a;

    public WordSet1(String s) {
        a = new TreeSet<>();
        String[] r = s.toLowerCase().trim().split("\\s+");
        for (int i = 0; i < r.length; i++)
            a.add(r[i]);
    }

    public WordSet1() {
        a = new TreeSet<>();
    }

    public WordSet1 union(WordSet1 b) {
        WordSet1 c = new WordSet1();
        c.a.addAll(this.a);
        c.a.addAll(b.a);
        return c;
    }

    public WordSet1 intersection(WordSet1 b) {
        WordSet1 c = new WordSet1();
        for (String i : this.a) {
            for (String j : b.a) {
                if (i.compareTo(j) == 0)
                    c.a.add(i);
            }
        }
        return c;
    }
    @Override
    public String toString() {
        String r = "";
        for (String i : a)
            r += i + ' ';
        return r;
    }
}
public class J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet1 s1 = new WordSet1(in.nextLine());
        WordSet1 s2 = new WordSet1(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
  
}