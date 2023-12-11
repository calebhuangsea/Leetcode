package Weekly375;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[] nums = {1,3,2,3,3, 1};
        int k = 2;
        System.out.println(q3.countSubarrays(nums, k));
    }
    public long countSubarrays(int[] nums, int k) {
//        You are given an integer array nums and a positive integer k.
//
//        Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
//
//                A subarray is a contiguous sequence of elements within an array.
        int max = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        Deque<Integer> dq = new LinkedList<>();
        // need to keep track of start indexes
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                if (dq.size() == k) {
                    dq.pollFirst();
                }
                dq.offerLast(i);
            }
            if (dq.size() == k) {
                ans += dq.peekFirst() + 1;
            }
        }

        return ans;
    }

    public long countSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] prefixSum = new int[n + 1];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (nums[i] == max ? 1 : 0);
        }

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int maxCount = prefixSum[right + 1] - prefixSum[left];
                if (maxCount >= k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
