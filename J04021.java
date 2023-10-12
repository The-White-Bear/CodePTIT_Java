package CodePTIT_Java;
import java.util.Scanner;
import java.util.Arrays;

class IntSet1 {
    private int[] set;
    private int size;

    public IntSet1(int[] inputArray) {
        set = new int[1000];
        size = 0;
        for (int i = 0; i < inputArray.length; i++) {
            insert(inputArray[i]);
        }
    }

    public void insert(int value) {
        if (!contains(value)) {
            set[size] = value;
            size++;
            Arrays.sort(set, 0, size);
        }
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (set[i] == value) {
                return true;
            }
        }
        return false;
    }

    public IntSet1 union(IntSet1 otherSet) {
        IntSet1 result = new IntSet1(new int[]{});
        for (int i = 0; i < this.size; i++) {
            result.insert(this.set[i]);
        }
        for (int i = 0; i < otherSet.size; i++) {
            result.insert(otherSet.set[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(set[i]);
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
public class J04021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        IntSet1 s1 = new IntSet1(a);
        IntSet1 s2 = new IntSet1(b);
        IntSet1 s3 = s1.union(s2);
        System.out.println(s3);
    }
}