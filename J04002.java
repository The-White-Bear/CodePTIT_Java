package CodePTIT_Java;
import java.util.Scanner;

class Rectangle{
    private double length,width;
    private String color;
    public Rectangle(){
        length=1;
        width=1;
    }
    public Rectangle(double length,double width,String color){
        this.width=width;
        this.length=length;
        this.color=color;
    }
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public String getColor(){
        return color.substring(0,1).toUpperCase()+color.substring(1).toLowerCase();
    }
    public void setLength(double length){
        this.length=length;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public void setColor(String color){
        this.color=color;
    }
    public double findArea()
    {
        return length*width;
    }
    public double findPerimeter()
    {
        return 2*(length+width);
    }
    @Override
    public String toString() {
        return String.format("%d %d %s", (int) findPerimeter(), (int) findArea(), getColor());
    }
}
public class J04002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        String c = sc.next();
        if (w > 0 && h > 0) {
            Rectangle rect = new Rectangle(w, h, c);
            System.out.println(rect);
        } else {
            System.out.println("INVALID");
        }
    }

}
