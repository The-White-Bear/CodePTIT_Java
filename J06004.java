package CodePTIT_Java;

import java.util.*;



public class J06004 {
    public static class Student {
        String id;
        String name;
        String phone;
        int group;

        public Student(String id, String name, String phone, int group) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.group = group;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            String name = scanner.next();
            String phone = scanner.next();
            int group = scanner.nextInt();
            students.add(new Student(id, name, phone, group));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.id.compareTo(s2.id);
            }
        });

        String[] exercises = new String[m];
        for (int i = 0; i < m; i++) {
            exercises[i] = scanner.next();
        }

        for (Student student : students) {
            System.out.println(student.id + " " + student.name + " " + student.phone + " " + student.group + " " + exercises[student.group - 1]);
        }
    }
}