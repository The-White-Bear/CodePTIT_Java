package CodePTIT_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Name implements Comparable<Name> {
    public String name;
    public List<String> tenviettat = new ArrayList<>();

    public Name(String name) {
        this.name = normalize(name);
        tenviettat = getTenviettat();
    }

    public List<String> getTenviettat() {

        String[] words = name.split(" ");
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            StringBuilder res = new StringBuilder();

            for (int j = 0; j <words.length; j++) {
                if(j==cnt)
                {
                    res.append("*");
                }
                else
                {
                    res.append(words[j].charAt(0));
                }
                res.append(".");
            }
            res = new StringBuilder(res.substring(0, res.length() - 1));
            tenviettat.add(res.toString());
            cnt++;

        }
        return tenviettat;
    }

    public String normalize(String name) {
        name = name.trim();
        StringBuilder res = new StringBuilder();
        String[] words = name.split(" ");
        for (String word : words) {
            res.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return res.toString();
    }

    @Override
    public int compareTo(Name o) {
        String[] name1 = this.name.split(" ");
        String[] name2 = o.name.split(" ");
        if (name1.length != name2.length) return name1.length - name2.length;
        int i=name1.length-1;
        if(!name1[i].equals(name2[i]))
        {
            return name1[i].compareTo(name2[i]);

        }
        else
        {
            return name1[0].compareTo(name2[0]);
        }

    }
}

public class J07071 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<Name> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String name = sc.nextLine();
            list.add(new Name(name));
        }
        Collections.sort(list);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++)
        {
            String viettat = sc.nextLine().trim();
            for (Name name : list) {

                if (name.tenviettat.contains(viettat)) {
                    System.out.println(name.name);
                }
            }
        }


    }

}