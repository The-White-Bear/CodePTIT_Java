package CodePTIT_Java;
import java.util.Arrays;
import java.util.Scanner;

public class J02009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] T = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
            D[i] = scanner.nextInt();
        }
        Passenger[] passengers = new Passenger[N];
        for (int i = 0; i < N; i++) {
            passengers[i] = new Passenger(T[i], D[i]);
        }
        Arrays.sort(passengers);
        int currentTime = 0;
        for (int i = 0; i < N; i++) {
            currentTime = Math.max(currentTime, passengers[i].arrivalTime) + passengers[i].checkInTime;
        }
        System.out.println(currentTime);
    }

    static class Passenger implements Comparable<Passenger> {
        int arrivalTime;
        int checkInTime;

        public Passenger(int arrivalTime, int checkInTime) {
            this.arrivalTime = arrivalTime;
            this.checkInTime = checkInTime;
        }

        @Override
        public int compareTo(Passenger o) {
            return this.arrivalTime - o.arrivalTime;
        }
    }
}
