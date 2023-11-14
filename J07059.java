package CodePTIT_Java;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Exam implements Comparable<Exam> {
    String id;
    Date datetime;
    String roomId;

    public Exam(String id, Date datetime, String roomId) {
        this.id = id;
        this.datetime = datetime;
        this.roomId = roomId;
    }
    @Override
    public int compareTo(Exam o) {
        int compare = this.datetime.compareTo(o.datetime);
        if (compare == 0)
            return this.id.compareTo(o.id);
        else
            return compare;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        return id + " " + sdf.format(datetime) + " " + roomId;
    }

}

public class J07059{
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(new File("CATHI.in"));

        int n = scanner.nextInt();
        scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        List<Exam> exams = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String date = scanner.nextLine();
            String time = scanner.nextLine();
            String roomId = scanner.nextLine();

            Date datetime = sdf.parse(date + " " + time);
            exams.add(new Exam(String.format("C%03d", i + 1), datetime, roomId));
        }

        Collections.sort(exams);
        for (Exam exam : exams) {
            System.out.println(exam);
        }
    }
}
