import java.util.Scanner;
import java.math.*;
class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static Point nextPoint(Scanner scanner) {
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        return new Point(x, y);
    }
}

class Triangle {
    Point p1, p2, p3;

    Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    double getPerimeter() {
        double res = getDistance(p1, p2) + getDistance(p2, p3) + getDistance(p3, p1);
        return Double.parseDouble(String.format("%.3f", res));
    }


    boolean valid() {
        double a = getDistance(p1, p2);
        double b = getDistance(p2, p3);
        double c = getDistance(p3, p1);
        return (a + b > c) && (b + c > a) && (c + a > b);
    }
}

public class J04019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
