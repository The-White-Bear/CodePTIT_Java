package CodePTIT_Java;
import java.io.*;
import java.util.*;

public class J07022 {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("DATA.in"));
            String line;
            List<String> words = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    try {
                        Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                        words.add(token);
                    }
                }
            }
            Collections.sort(words);
            for (String word : words) {
                System.out.print(word + " ");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}