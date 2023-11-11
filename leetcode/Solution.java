import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int d = 7;
        int e = 3;
        int n = 33;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int c = sc.nextInt();
            if (c < 0) {
                break;
            }
            long m = (long) Math.pow(c, d) % n;
            System.out.print((char)(m - 1 + 'A'));
        }
    }
}
