package M215KthLargestElementInAnArray;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Time Complexity Best O(N) Worst O(N^2) 5ms 96.67%
 * Space Complexity O(1) 50.6MB 70.97%
 */
class Solution {
    int[] n;
    private void swap(int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    private int partition(int left, int right, int index) {
        int pivot = n[index];
        // move pivot to the end
        swap(index, right);
        for (int i = left; i < right; i++) {
            // move smallest element to the left
            if (n[i] < pivot) {
                swap(left++, i);
            }
        }
        // move pivot back to the middle(keep order)
        swap(left, right);
        //return how many are smaller
        return left;
    }

    private int quickSelect(int lo, int hi, int k) {
        if (lo == hi) {
            return n[lo];
        }
        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = lo + random_num.nextInt(hi - lo);
        pivot_index = partition(lo, hi, pivot_index);
        if (k == pivot_index) {
            return n[k];
        } else if (k < pivot_index) {
            return quickSelect(lo, pivot_index - 1, k);
        } else {
            return quickSelect(pivot_index + 1, hi, k);
        }
    }

    public int findKthLargest(int[] n, int k) {
        this.n = n;
        return quickSelect(0, n.length - 1, n.length - k);
    }
}

//public class Solution {
//    /**
//     * Time Complexity O(Nlog(K))
//     * Space Complexity O(K)
//     */
//    public int findKthLargest(int[] nums, int k) {
//        // init heap 'the smallest element first'
//        PriorityQueue<Integer> heap =
//                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
//
//        // keep k largest elements in the heap
//        for (int n: nums) {
//            heap.add(n);
//            if (heap.size() > k)
//                heap.poll();
//        }
//
//        // output
//        return heap.poll();
//    }
//}
