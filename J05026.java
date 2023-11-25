package CodePTIT_Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GiangVien1  {
    public String id, name, subject;
    public static int Num = 0;

    public GiangVien1(String name, String subject) {
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
    public String toString() {
        return id + " " + name + " " + subject;
    }
}

public class J05026 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<GiangVien2> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String name=sc.nextLine();
            String subject=sc.nextLine();
            list.add(new GiangVien2(name,subject));
        }
        int q=sc.nextInt();
        sc.nextLine();
        while (q-->0){
            String subject=sc.nextLine();
            subject=normalizeSubject(subject);
            for(GiangVien2 x:list){
                if(x.normalizeSubject(x.subject).equals(x.normalizeSubject(subject))){
                    System.out.println(x);
                }
            }
        }
        
    }
    public static String normalizeSubject(String subject) {
        StringBuilder res = new StringBuilder();
        String[] s = subject.split(" ");
        for (int i = 0; i < s.length; i++) {
            res.append(Character.toUpperCase(s[i].charAt(0)));
        }
        return res.toString();
    }
}

