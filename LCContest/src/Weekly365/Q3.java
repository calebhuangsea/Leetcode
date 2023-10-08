package Weekly365;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[] nums = {2,1,5,7,7,1,6,3};
        int target = 39;
        System.out.println(q3.minSizeSubarray(nums, target));
    }
    public int minSizeSubarray(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        int remain = target / sum * nums.length;
        target %= sum;

        int curr = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length * 2; j ++) {
            curr += nums[j % nums.length];
           while (curr > target) {
               curr -= nums[left % nums.length];
               left ++;
           }
            if (curr == target) {
                min = Math.min(min, j - left + 1);
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min + remain;
    }
}
