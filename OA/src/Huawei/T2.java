package Huawei;

public class T2 {
//    题目：
//
//    给你一个二进制数组 nums，数组中只有0,1两种元素，你需要从中删掉一个0元素，如果没有0可以不删除。
//
//    请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
//
//    提示 1：
//    输入：nums = [1,1,0,1]
//    输出：3
//    解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
//    示例 2：
//    输入：nums = [0,1,1,1,0,1,1,0,1]
//    输出：5
//    解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[] {1,1,0,1}, 1));
        System.out.println(longestSubarray(new int[] {0,1,1,1,0,1,1,0,1}, 1));
        System.out.println(longestSubarray(new int[] {1,1,1,1}, 1));
        System.out.println(longestSubarray(new int[] {0, 0, 0, 0}, 1));
        System.out.println(longestSubarray(new int[] {0, 0, 1, 0, 1, 0, 0}, 1));
    }
    public static int longestSubarray(int[] nums, int n) {
        int max = 0;
        int start = 0;
        int used = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                used++;
            }
            while (used > n) {
                if (nums[start++] == 0) {
                    used--;
                }
            }
            max = Math.max(i - start + 1 - used, max);
        }
        return max;
    }
}
