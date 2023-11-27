package CodePTIT_Java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05041 {
    public static class Employee implements Comparable<Employee> {
        public String id, name, position;
        public double dailySalary, workingDays;

        public Employee(String name, double dailySalary, double workingDays, String position) {
            this.id = "NV" + String.format("%02d", Num++);
            this.name = name;
            this.dailySalary = dailySalary;
            this.workingDays = workingDays;
            this.position = position;
        }

        public double calculateSalary() {
            return dailySalary * workingDays;
        }

        public double calculateBonus() {
            double baseSalary = calculateSalary();
            if (workingDays >= 25) {
                return 0.2 * baseSalary;
            } else if (workingDays >= 22) {
                return 0.1 * baseSalary;
            } else {
                return 0;
            }
        }

        public double calculateAllowance() {
            switch (position) {
                case "GD":
                    return 250000;
                case "PGD":
                    return 200000;
                case "TP":
                    return 180000;
                case "NV":
                    return 150000;
                default:
                    return 0;
            }
        }

        public double calculateNetSalary() {
            return calculateSalary() + calculateBonus() + calculateAllowance();
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(calculateSalary()) + " " + Math.round(calculateBonus()) + " " + Math.round(calculateAllowance()) + " " + Math.round(calculateNetSalary());
        }
        @Override
        public int compareTo(Employee o) {
            return this.calculateNetSalary() > o.calculateNetSalary() ? -1 : 1;
        }
    }

    public static int Num = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Employee> employees = new ArrayList<>();

        double totalSalary = 0;

        while (n-- > 0) {
            String name = sc.nextLine();
            double dailySalary = sc.nextDouble();
            double workingDays = sc.nextDouble();
            sc.nextLine();
            String position = sc.nextLine();

            Employee employee = new Employee(name, dailySalary, workingDays, position);
            employees.add(employee);

            totalSalary += employee.calculateNetSalary();
        }
        Collections.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}


