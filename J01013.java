package CodePTIT_Java;
import java.util.*;

public class J01013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> primes = sieveOfEratosthenes(2_000_000);

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();
            totalSum += sumPrimeFactors(num, primes);
        }

        System.out.println(totalSum);
    }
    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
    public static long sumPrimeFactors(long num, List<Integer> primes) {
        long sum = 0;

        for (int prime : primes) {
            if (prime * prime > num) {
                break;
            }
            while (num % prime == 0) {
                sum += prime;
                num /= prime;
            }
        }

        if (num > 1) {
            sum += num;
        }

        return sum;
    }
}