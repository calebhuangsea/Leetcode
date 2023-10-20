package Weekly367;

import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Q1 q = new Q1();
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return new int[] {-1, -1};
    }
}
