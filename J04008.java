package CodePTIT_Java;

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import CodePTIT_Java.Point;
public class J04008 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Point[] arr = new Point[3];
            for (int i = 0; i < 3; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                arr[i] = new Point(x, y);
            }
            double a = arr[0].distance(arr[1]);
            double b = arr[1].distance(arr[2]);
            double c = arr[0].distance(arr[2]);
            if (a + b > c && b + c > a && a + c > b) {
                System.out.printf("%.3f", a + b + c);
            } else {
                System.out.println("INVALID");
            }
        }
    }
}