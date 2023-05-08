package DIV2.R872;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] x = new int[n];
            int count = 0;
            int left = 0;
            int right = 0;
            int leftmost = m + 1;
            int rightmost = 0;
            int[] seat = new int[m + 1];
            for (int j = 0; j < n; j++) {
                x[j] = sc.nextInt();
                if (x[j] == -1) {
                    left++;
                } else if (x[j] == -2) {
                    right++;
                } else if (seat[x[j]] != 1) {
                    seat[x[j]] = 1;
                    leftmost = Math.min(x[j], leftmost);
                    rightmost = Math.max(x[j], rightmost);
                    count++;
                }
            }
            // need to find a way to calculate left and right// intervals?
            // 如果左边装不下只能装到最右边
            // 如果右边装不下只能装到最左边
            // 考虑最多的先
            if (left == 0 && right == 0) {
                System.out.println(count);
                continue;
            }
            int llspace = leftmost - 1;
            int lrspace = m - count - llspace;
            int rrspace = m - rightmost;
            int rlspace = m - count - rrspace;

            int sum1 = count;// 左先
            int sum2 = count;// 右先
            // left
            if (rlspace >= left) {
                sum1 += left;
                sum1 += Math.min(rrspace, right);
            } else {
                sum1 += rlspace;
                left -= rlspace;
                sum1 += Math.max(left, right);
            }
            // right
            if (lrspace >= right) {
                sum2 += right;
                sum2 += Math.min(llspace, left);
            } else {
                sum2 += lrspace;
                right -= lrspace;
                sum2 += Math.max(left, right);
            }

            System.out.println(Math.min(m,Math.min(n, Math.max(sum1, sum2))));
        }
    }
}
