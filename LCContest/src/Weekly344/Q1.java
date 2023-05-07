package Weekly344;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distinctDifferenceArray(new int[] {3,2,3,4,2})));
    }
    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        // calculate the prefix and suffix
        int[] prefix = new int[n];
        int[] suffix = new int[n + 1];
        int[] count = new int[51];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == 1) {
                pre++;
            }
            prefix[i] = pre;
        }
        count = new int[51];
        int suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            count[nums[i]]++;
            if (count[nums[i]] == 1) {
                suf++;
            }
            suffix[i] = suf;
        }
        for (int i = 0; i < n; i++) {
            diff[i] =  prefix[i] - suffix[i + 1];
        }
        return diff;
    }
}
