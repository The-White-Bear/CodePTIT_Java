package CodePTIT_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidate {
    private static int nextId = 1;

    private String name;
    private String dob;
    private double theoryScore;
    private double practicalScore;
    private double bonus;
    private double averageScore;
    private String result;
    private int id;

    public Candidate(String name, String dob, double theoryScore, double practicalScore) {
        this.name = normalizeName(name);
        this.dob = dob;
        this.theoryScore = theoryScore;
        this.practicalScore = practicalScore;
        this.bonus = calculateBonus(theoryScore, practicalScore);
        this.averageScore = calculateAverageScore(theoryScore, practicalScore, bonus);
        this.result = calculateResult(averageScore);
        this.id = nextId++;
    }

    private String normalizeName(String name) {
        name = name.trim().replaceAll("\\s+", " ");
        String[] words = name.split("\\s+");
        StringBuilder normalized = new StringBuilder();
        for (String word : words) {
            normalized.append(Character.toUpperCase(word.charAt(0)));
            normalized.append(word.substring(1).toLowerCase());
            normalized.append(" ");
        }
        return normalized.toString().trim();
    }


    private double calculateBonus(double theoryScore, double practicalScore) {
        if (theoryScore >= 8 && practicalScore >= 8) {
            return 1.0;
        } else if (theoryScore >= 7.5 && practicalScore >= 7.5) {
            return 0.5;
        }
        return 0.0;
    }

    private double calculateAverageScore(double theoryScore, double practicalScore, double bonus) {
        double totalScore =( theoryScore + practicalScore ) /2.0 + bonus;
        totalScore=Math.round(totalScore);
        return Math.min(totalScore, 10);
    }

    private String calculateResult(double averageScore) {
        if (averageScore < 5.0) {
            return "Truot";
        } else if (averageScore >= 5.0 && averageScore < 7.0) {
            return "Trung binh";
        } else if (averageScore == 7.0) {
            return "Kha";
        } else if (averageScore == 8.0) {
            return "Gioi";
        } else {
            return "Xuat sac";
        }
    }

    public int getAge() {
        String[] parts = dob.split("/");
        int year = Integer.parseInt(parts[2]);
        return 2021 - year; // Assuming the current year is 2023
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return "PH" + String.format("%02d", id) + " " +
                name + " " +
                getAge() + " " +
                df.format(averageScore) + " " +
                result;
    }
}

public class J07053 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String dob = sc.nextLine();
            double theoryScore = Double.parseDouble(sc.nextLine());
            double practicalScore = Double.parseDouble(sc.nextLine());
            candidates.add(new Candidate(name, dob, theoryScore, practicalScore));
        }

        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }
}
