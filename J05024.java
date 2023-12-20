package CodePTIT_Java;
import java.util.Scanner;
import java.util.ArrayList;

class Student7 {

    private String id;
    private String name;
    private String className;
    private String email;

    public Student7(String id, String name, String className, String email) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + email;
    }
}

public class J05024{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student7> arrayList = new ArrayList<>();
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            arrayList.add(new Student7(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
        }
        int Q = scanner.nextInt();
        scanner.nextLine();
        while (Q-- > 0) {
            String Major = scanner.nextLine();
            String check = normalMajor(Major);
            System.out.println("DANH SACH SINH VIEN NGANH " + Major.toUpperCase()  + ":");
            for (int i = 0; i < arrayList.size(); i++) {
                String major = arrayList.get(i).getId().substring(5,7);
                if (check.equals(major)) {
                    System.out.println(arrayList.get(i));
                }
            }
        }
    }
    public static String normalMajor(String Major){
        if(Major.equals("Ke toan"))
        {
            return "KT";
        }
        else if (Major.equals("Cong nghe thong tin"))
        {
            return "CN";
        }
        else if (Major.equals("An toan thong tin"))
        {
            return "AT";
        }
        else if (Major.equals("Vien thong"))
        {
            return "VT";
        }
        else
        {
            return "DT";
        }
    }
}