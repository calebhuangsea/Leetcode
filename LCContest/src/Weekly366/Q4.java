package Weekly366;
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Q4 q = new Q4();
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(6);
        nums.add(5);
        nums.add(8);

        q.maxSum(nums, 2);
        System.out.println("===============");
//        List<Integer> nums2 = new ArrayList<>();
//        nums2.add(4);
//        nums2.add(5);
//        nums2.add(4);
//        nums2.add(7);
//        q.maxSum(nums2, 4);
//        System.out.println("===============");
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(i + " : " + (i|(11 - i)));
//        }
    }


    public int maxSum(List<Integer> nums, int k) {
        int[] bit = new int[32];
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    bit[i]++;
                }
                num >>= 1;
                i++;
            }
        }
        long mod = (long)1e9 + 7;
        long res = 0;
        for (int i = 1; i <= k; i++) {
            long max = 0;
            for (int j = 0; j < 32; j++) {
                if (bit[j] > 0) {
                    max += (1 << j);
                    bit[j]--;
                }
            }
            res += max * max % mod;
            res %= mod;
        }
        return (int)res;
    }
}
