package CodePTIT_Java;
import java.util.Scanner;

class Point1 {

    private double x;
    private double y;

    public Point1(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point1 nextPoint(Scanner scanner) {
        return new Point1(scanner.nextDouble(), scanner.nextDouble());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Triangle {

    private Point1 a;
    private Point1 b;
    private Point1 c;

    public Triangle(Point1 a, Point1 b, Point1 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean valid() {
        double ab = Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
        double bc = Math.sqrt((c.getX() - b.getX()) * (c.getX() - b.getX()) + (c.getY() - b.getY()) * (c.getY() - b.getY()));
        double ca = Math.sqrt((a.getX() - c.getX()) * (a.getX() - c.getX()) + (a.getY() - c.getY()) * (a.getY() - c.getY()));
        if (ab + bc > ca && bc + ca > ab && ca + ab > bc) {
            return true;
        }
        return false;
    }

    public String getPerimeter() {
        double ab = Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
        double bc = Math.sqrt((c.getX() - b.getX()) * (c.getX() - b.getX()) + (c.getY() - b.getY()) * (c.getY() - b.getY()));
        double ca = Math.sqrt((a.getX() - c.getX()) * (a.getX() - c.getX()) + (a.getY() - c.getY()) * (a.getY() - c.getY()));
        return String.format("%.3f", ab + bc + ca);
    }
}

public class J04019{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Triangle a = new Triangle(Point1.nextPoint(sc), Point1.nextPoint(sc), Point1.nextPoint(sc));
            if (!a.valid()) {
                System.out.println("INVALID");
            } else {
                System.out.println(a.getPerimeter());
            }
        }
    }
}