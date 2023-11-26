package CodePTIT_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05031 {
    public static class Student implements Comparable<Student> {

        public String id, name, className;
        public float[] score = new float[3];

        public Student(String id, String name, String className, float[] score) {
            this.id = id;
            this.name = name;
            this.className = className;
            this.score = score;
        }

        public int compareTo(Student o) {
            return this.name.compareTo(o.name);
        }

        public String toString() {
            return this.id + " " + this.name + " " + this.className + " " + String.format("%.1f", this.score[0]) + " " + String.format("%.1f", this.score[1]) + " " + String.format("%.1f", this.score[2]) ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            String className = sc.nextLine();
            float[] score = new float[3];
            for (int j = 0; j < 3; j++) {
                score[j] = Float.parseFloat(sc.nextLine());
            }
            list.add(new Student(id, name, className, score));
        }
        Collections.sort(list);
        int cnt=1;
        for (Student student : list) {
            System.out.print(cnt++ + " ");
            System.out.println(student);
        }
    }

}
