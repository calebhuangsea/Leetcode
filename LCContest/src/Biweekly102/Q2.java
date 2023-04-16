package Biweekly102;

public class Q2 {
    public long[] findPrefixScore(int[] nums) {
        long[] res = new long[nums.length];
        long count = 0;
        long max = 0;
        res[0] = count + max;
        for (int i = 0; i < nums.length; i++) {
            //先算max 再算count
            max = Math.max(nums[i], max);
            count += max + nums[i];
            res[i] = count;
        }
        return res;
    }
}
