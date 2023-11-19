package CodePTIT_Java;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JKT013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            ArrayList<Long> res = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i=1;i<=n;i++)
            {
                ArrayList<Long> luckyNumbers = findLuckyNumbers(i);
                res.addAll(luckyNumbers);
            }
            Collections.sort(res, Collections.reverseOrder());
            System.out.println(res.size());
            printLuckyNumbers(res);
        }
    }

    private static ArrayList<Long> findLuckyNumbers(int n) {
        ArrayList<Long> luckyNumbers = new ArrayList<>();
        generateLuckyNumbers(0, 0, n, luckyNumbers);
        return luckyNumbers;
    }

    private static void generateLuckyNumbers(long num, int count, int n, ArrayList<Long> luckyNumbers) {
        if (count == n) {
            luckyNumbers.add(num);
            return;
        }
        generateLuckyNumbers(num * 10 + 6, count + 1, n, luckyNumbers);
        generateLuckyNumbers(num * 10 + 8, count + 1, n, luckyNumbers);
    }
    private static void printLuckyNumbers(ArrayList<Long> luckyNumbers) {
        for (Long num : luckyNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
