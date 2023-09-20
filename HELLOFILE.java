package CodePTIT_Java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class HELLOFILE {
    public static void main(String[] args)  throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("Hello.txt"));
        while(scanner.hasNext())
        {
            System.out.println(scanner.nextLine());
        }
    }
}
