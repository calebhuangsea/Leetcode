package Weekly365;
import java.util.*;
public class Q1 {
    public long maximumTripletValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i ++) {
            for (int j = i + 1; j < nums.length - 1; j ++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    int a = nums[i];
                    int b = nums[j];
                    int c = nums[k];
                    max = Math.max(max, (a - b) * c);
                }
            }
        }
        return max < 0 ? 0 : max;
    }
}
