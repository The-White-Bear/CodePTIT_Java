package CodePTIT_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07002 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "DATA.in";
        int sum = 0;

        Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    sum += number;
                } else {
                    scanner.nextLine();
                }
            }


        System.out.println(sum);
    }
}
