package CodePTIT_Java;
import java.util.*;
import java.lang.Math;
class Phanso {
    private long tuso;
    private long mauso;

    public Phanso(long tuso, long mauso) {
        this.tuso = tuso;
        this.mauso = mauso;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Phanso rutGon() {
        long ucln = gcd(tuso, mauso);
        return new Phanso(tuso / ucln, mauso / ucln);
    }

    public Phanso cong(Phanso other) {
        long newTuso = tuso * other.mauso + other.tuso * mauso;
        long newMauso = mauso * other.mauso;
        return new Phanso(newTuso, newMauso);
    }

    @Override
    public String toString() {
        return tuso + "/" + mauso;
    }
}

public class J04004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long tusoP = scanner.nextLong();
        long mausoP = scanner.nextLong();
        long tusoQ = scanner.nextLong();
        long mausoQ = scanner.nextLong();

        Phanso p = new Phanso(tusoP, mausoP);
        Phanso q = new Phanso(tusoQ, mausoQ);

        Phanso sum = p.cong(q).rutGon();
        System.out.println(sum);
    }
}
