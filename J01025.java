package CodePTIT_Java;
import java.util.Scanner;

public class J01025 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] rectangle1=new int[4];
        int[] rectangle2=new int[4];
        for(int i=0;i<4;i++){
            rectangle1[i]=scanner.nextInt();
        }
        for(int i=0;i<4;i++){
            rectangle2[i]=scanner.nextInt();
        }
        long smallestSquareArea = findSmallestSquare(rectangle1, rectangle2);
        System.out.println(smallestSquareArea);
    }

    public static long findSmallestSquare(int[] rectangle1, int[] rectangle2) {

        int leftBottomX = Math.min(rectangle1[0], rectangle2[0]);
        int leftBottomY = Math.min(rectangle1[1], rectangle2[1]);
        int rightTopX = Math.max(rectangle1[2], rectangle2[2]);
        int rightTopY = Math.max(rectangle1[3], rectangle2[3]);
        int sideLength = Math.max(rightTopX - leftBottomX, rightTopY - leftBottomY);
        long squareArea = sideLength * sideLength;

        return squareArea;
    }
}
