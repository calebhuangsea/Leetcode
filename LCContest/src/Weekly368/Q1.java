package Weekly368;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] nums = {5,4,8,7,10,2};
        System.out.println(q1.minimumSum(nums));
    }
    public int minimumSum(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.min(prefix[i - 1], nums[i]);
        }
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }
        int sum = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > prefix[i - 1] && nums[i] > suffix[i + 1]) {
                sum = Math.min(sum, prefix[i - 1] + suffix[i + 1] + nums[i]);
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}
