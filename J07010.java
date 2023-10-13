package CodePTIT_Java;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
class Student1{
    public static int Num_student =1;
    private String id,name,lop,dob;
    private float gpa;
    public Student1(String name, String lop, String dob, float gpa) throws ParseException {
        this.id = "B20DCCN" + String.format("%03d", Num_student++);
        this.name = name;
        this.lop = lop;
        this.gpa = gpa;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        this.dob = formatter.format(formatter.parse(dob));
    }
    @Override
    public String toString(){
        return  id+" "+name+" "+lop+" "+dob+" "+String.format("%.2f",gpa);
    }
}
public class J07010 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String dob = sc.nextLine();
            float gpa = Float.parseFloat(sc.nextLine());
            Student1 stu = new Student1(name, lop, dob, gpa);
            System.out.println(stu);
        }
    }
}
