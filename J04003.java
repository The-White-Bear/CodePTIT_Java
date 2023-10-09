package CodePTIT_Java;
import java.util.*;
import java.lang.Math;
import CodePTIT_Java.J04003;
class Phanso{
    private long tuso;
    private long mauso;
    public Phanso(){

    }
    public Phanso(long tuso,long mauso){
        this.tuso = tuso;
        this.mauso = mauso;
    }
    public void setTuso(long tuso){
        this.tuso = tuso;
    }
    public void setMauso(long mauso){
        this.mauso = mauso;
    }
    public long getTuso(){

        return tuso;
    }
    public long getMauso(){
        return mauso;
    }
    public String toString(){
        long n=gcd(tuso,mauso);
        tuso=tuso/n;
        mauso=mauso/n;
        return tuso+"/"+mauso;
    }

    private long gcd(long tuso, long mauso) {
        if (mauso == 0) {
            return tuso;
        }
        return gcd(mauso, tuso % mauso);
    }
}
public class J04003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a=scanner.nextLong();
        long b=scanner.nextLong();
        Phanso phanso=new Phanso(a,b);
        System.out.println(phanso);
    }
}
