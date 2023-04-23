package Weekly342;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        System.out.println();
    }
    public static int sumOfMultiplesOf(int k, int n) {
        int numTerms = n / k;
        return k * numTerms * (numTerms + 1) / 2;
    }
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
