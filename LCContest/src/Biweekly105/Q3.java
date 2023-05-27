package Biweekly105;
import java.util.*;
public class Q3 {

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.maxStrength(new int[]{3, -1, -5, 2, 5, -9}));
    }
    /**
     * You are given a 0-indexed integer array nums representing the score of students in an exam. The teacher would like to form one non-empty group of students with maximal strength, where the strength of a group of students of indices i0, i1, i2, ... , ik is defined as nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​].
     *
     * Return the maximum strength of a group the teacher can create.
     */
    long res = 0;
    public long maxStrength(int[] nums) {
        if (nums.length == 1) return nums[0];
        dfs(nums, 0, 1, 0);
        return res;
    }

    private void dfs(int[] nums, int idx, long cur, int count) {
        if (count > 0) {
            res = Math.max(res, cur);
        }
        if (idx >= nums.length) {
            return;
        }
        dfs(nums, idx + 1, cur * nums[idx], count + 1);
        dfs(nums, idx + 1, cur, count);
    }
}
