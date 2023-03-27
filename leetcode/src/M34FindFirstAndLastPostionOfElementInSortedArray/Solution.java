package M34FindFirstAndLastPostionOfElementInSortedArray;

public class Solution {
    /**
     * Greedy: keep track of current maximum range and steps
     * Time Complexity O(N) 99.53%
     * Space Complexity O(1) 43.4MB 15.11%
     */
    public int jump(int[] nums) {
        int answer = 0;
        int currEnd = 0;
        int currFar = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFar = Math.max(currFar, nums[i] + i);
            if (i == currEnd) {
                currEnd = currFar;
                answer++;
            }
        }

        return answer;
    }

    /**
     * Binary Search and deal with edge cases
     * Time Complexity O(log(N)) 0ms 100%
     * Space Complexity O(1) 45.5MB 79.14%
     */
//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0) {
//            return new int[] {-1, -1};
//        }
//        int lo = 0;
//        int hi = nums.length - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (nums[mid] == target) {
//                // find left and right
//                int left = mid;
//                int right = mid;
//                while (left > 0 && nums[left - 1] == target) {left--;}
//                while (right < nums.length - 1 && nums[right + 1] == target) {right++;};
//                return new int[] {left, right};
//            } else if (nums[mid] > target) {
//                hi = mid - 1;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        return new int[] {-1, -1};
//    }
}
