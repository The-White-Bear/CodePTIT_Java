package CodePTIT_Java;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

class IntSet {
    private int[] set;
    private int size;

    public IntSet(int[] inputArray) {
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

    public IntSet union(IntSet otherSet) {
        IntSet result = new IntSet(new int[]{});
        for (int i = 0; i < this.size; i++) {
            result.insert(this.set[i]);
        }
        for (int i = 0; i < otherSet.size; i++) {
            result.insert(otherSet.set[i]);
        }
        return result;
    }
    public IntSet intersection(IntSet otherSet){
        IntSet result = new IntSet(new int[]{});
        for (int i = 0; i < this.size; i++) {
            if (otherSet.contains(this.set[i])){
                result.insert(this.set[i]);
            }
        }
        return result;
    }
    public IntSet difference(IntSet otherSet){
        IntSet result = new IntSet(new int[]{});
        for (int i = 0; i < this.size; i++) {
            if (!otherSet.contains(this.set[i])){
                result.insert(this.set[i]);
            }
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
public class J07009{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
    public static void main6718738(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }

}


