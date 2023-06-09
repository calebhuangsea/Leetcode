package E1249CheckIfaNumberIsMajorityElementinaSortedArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "/a/b/c";
        System.out.println(s.lastIndexOf("/"));
    }
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int n : nums) {
            if (n == target) {
                count++;
            }
        }
        return count > nums.length / 2;
    }
}
