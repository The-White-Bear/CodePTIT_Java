package CodePTIT_Java;

import java.util.*;
import java.io.*;

public class CT2_B3{
    static int tcs(String s){
        int r = 0 ;
        for(int i=0;i<s.length();i++){
            r += (int)(s.charAt(i)-'0');
        }
        return r;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) o.readObject();
        a.forEach(e -> {
            String s[] = e.split("[a-zA-Z]+");
            String r="";
            for(String i : s) r+=i;
            r = r.replaceFirst("^0*", "");
            if(r.isEmpty()) r = "0";
            System.out.printf("%s %d\n",r,tcs(r));
        });
    }
}