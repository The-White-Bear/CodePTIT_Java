import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05034 {
    public static class Student implements Comparable<Student> {
        public int id;
        public String code;
        public String name;
        public String className;
        public String email;
        public String company;

        public Student(int id, String code, String name, String className, String email, String company) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.className = className;
            this.email = email;
            this.company = company;
        }

        @Override
        public int compareTo(Student o) {
            return this.name.compareTo(o.name);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String code = scanner.nextLine();
            String name = scanner.nextLine();
            String className = scanner.nextLine();
            String email = scanner.nextLine();
            String company = scanner.nextLine();
            students.add(new Student(i, code, name, className, email, company));
        }
        Collections.sort(students);
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String companyName = scanner.nextLine();
            List<Student> companyStudents = new ArrayList<>();
            for (Student student : students) {
                if (student.company.equals(companyName)) {
                    companyStudents.add(student);
                }
            }
            for (Student student : companyStudents) {
                System.out.println(student.id + " " + student.code + " " + student.name + " " + student.className + " " + student.email + " " + student.company);
            }
        }
    }
}
