package Weekly342;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        System.out.println(getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2));
    }

//    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
//        int n = nums.length;
//        int[] res = new int[n - k + 1];
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> rev = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < x - 1; i++) {
//            rev.offer(nums[i]);
//        }
//        for (int i = x - 1; i < k; i++) {
//            if (rev.isEmpty() || nums[i] > rev.peek()) {
//                pq.offer(nums[i]);
//            } else {
//                pq.offer(rev.poll());
//                rev.offer(nums[i]);
//            }
//        }
//        res[0] = Math.min(0, pq.peek());
//        for (int i = 1; i < n - k + 1; i++) {
//            int remove = nums[i - 1];
//            if (rev.isEmpty() || remove > rev.peek()) {
//                pq.remove(remove);
//            } else {
//                rev.remove(remove);
//                rev.offer(pq.poll());
//            }
//            if (rev.isEmpty() || nums[i + k - 1] > rev.peek()) {
//                pq.offer(nums[i + k - 1]);
//            } else {
//                pq.offer(rev.poll());
//                rev.offer(nums[i + k - 1]);
//            }
//            res[i] = Math.min(0, pq.peek());
//        }
//        return res;
//    }

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] arr = new int[101];
        for (int i = 0; i < k; i++) {
            arr[nums[i] + 50]++;
        }
        int count = 0;
        for (int i = 0; i < 101; i++) {
            count += arr[i];
            if (count >= x) {
                res[0] = Math.min(i - 50, 0);
                break;
            }
        }
        for (int i = 1; i < n - k + 1; i++) {
            arr[nums[i - 1] + 50]--;
            arr[nums[i + k - 1] + 50]++;
            count = 0;
            for (int j = 0; j < 101; j++) {
                count += arr[j];
                if (count >= x) {
                    res[i] = Math.min(j - 50, 0);
                    break;
                }
            }
        }
        return res;
    }
}
