package M31NextPermutation;

import java.util.Arrays;

class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Time: O(N^2)
     * Space: O(1)
     * @param nums
     */
//    public void nextPermutation(int[] nums) {
//        // Let's just check everything?
//        // just swap the last index with the first one that is smaller than it
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] >= nums[i + 1]) continue;
//            int min = -1;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] < nums[j] && ( min == -1 || nums[min] > nums[j])) {
//                    min = j;
//                }
//            }
//            if (min != -1) {
//                swap(nums, i, min);
//                // after this, we wanna sort from i to nums.length - 1
//                sort(nums, i + 1);
//                return;
//            }
//        }
//        Arrays.sort(nums);
//    }
//
//    private void sort(int[] nums, int in) {
//        for (int i = in; i < nums.length; i++) {
//            int min = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[min]) min = j;
//            }
//            swap(nums, min, i);
//        }
//    }
//
//    private void swap(int[] n, int i, int j) {
//        int t = n[i];
//        n[i] = n[j];
//        n[j] = t;
//    }
}
