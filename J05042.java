package CodePTIT_Java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class J05042 {
    public static class Student {
        public String name;
        public int AC, Try;

        public Student(String name, int AC, int aTry) {
            this.name = name;
            this.AC = AC;
            this.Try = aTry;
        }

        @Override
        public String toString() {
            return name + " " + AC + " " + Try;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.nextLine();
            int AC = sc.nextInt();
            int Try = sc.nextInt();
            sc.nextLine();

            Student student = new Student(name, AC, Try);
            students.add(student);
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.AC != s2.AC) {
                    return s2.AC - s1.AC;
                }
                if (s1.Try != s2.Try) {
                    return s1.Try - s2.Try;
                }
                return s1.name.compareTo(s2.name);
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }
    }
}