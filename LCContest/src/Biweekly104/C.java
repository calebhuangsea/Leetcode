package Biweekly104;
import java.util.*;
public class C {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.maximumOr(new int[] {8, 1, 2}, 2) );
    }

    public long maximumOr(int[] nums, int k) {
        // 每次可以对一个数怎么样，使得他们总和最大，greedy？每次都maximize
        long sum = 0;
        for (int n : nums) {
            sum |= n;
        }
        for (int i = 1; i <= k; i++) {
            long curr = 0;
        }

        return sum;
    }

}
