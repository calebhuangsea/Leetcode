package Weekly365;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        int[] nums = {1,10,3,4,19};
        System.out.println(q2.maximumTripletValue(nums));
    }
    public long maximumTripletValue(int[] nums) {
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            maxLeft[i] = i == 0 ? nums[i] : Math.max(maxLeft[i - 1], nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            maxRight[i] = i == nums.length - 1 ? nums[i] : Math.max(maxRight[i + 1], nums[i]);
        }

        long max = Long.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(max, ((long)maxLeft[i - 1] - nums[i]) * maxRight[i + 1]);
        }

        return max < 0 ? 0 : max;
    }
}
