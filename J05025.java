package CodePTIT_Java;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class GiangVien implements Comparable<GiangVien> {
    public String id, name, subject;
    public static int Num = 0;

    public GiangVien(String name, String subject) {
        this.id = "GV" + String.format("%02d", ++Num);
        this.name = name;
        this.subject = normalizeSubject(subject);
    }

    public String normalizeSubject(String subject) {
        StringBuilder res = new StringBuilder();
        String[] s = subject.split(" ");
        for (int i = 0; i < s.length; i++) {
                res.append(Character.toUpperCase(s[i].charAt(0)));
        }
        return res.toString();
    }

    @Override
    public int compareTo(GiangVien o) {
        String ten1[] = this.name.split(" ");
        String ten2[] = o.name.split(" ");
        if (ten1[ten1.length - 1].compareTo(ten2[ten2.length - 1]) == 0) {
            return this.id.compareTo(o.id);
        }
        return ten1[ten1.length - 1].compareTo(ten2[ten2.length - 1]);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + subject;
    }
}

public class J05025 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<GiangVien> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String name=sc.nextLine();
            String subject=sc.nextLine();
            list.add(new GiangVien(name,subject));
        }
        Collections.sort(list);
        for(GiangVien x:list){
            System.out.println(x);
        }
    }
}
