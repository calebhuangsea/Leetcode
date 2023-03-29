package M347TopKFrequentElements;

import java.util.*;

public class Solution {
    /**
     * Quick Select
     * Time Complexity O(N) best O(N^2) average 13ms 61.11%
     * Space Complexity O(N) 44.9MB 73.97%
     */
    int[] res;
    Map<Integer, Integer> map;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        res = new int[size];
        int i = 0;
        for (int n : map.keySet()) {
            res[i++] = n;
        }
        quickselect(0, size - 1, size - k);
        return Arrays.copyOfRange(res, size - k, size);
    }

    private void swap(int i, int j) {
        int t = res[i];
        res[i] = res[j];
        res[j] = t;
    }

    private int partition(int lo, int hi, int index) {
        int pivot = map.get(res[index]);
        swap(index, hi);
        for (int i = lo; i <= hi; i++) {
            if (map.get(res[i]) < pivot) {
                swap(lo++, i);
            }
        }
        swap(lo, hi);
        return lo;
    }

    private void quickselect(int lo, int hi, int k) {
        if (lo == hi) {
            return;
        }
        Random rd = new Random();
        int pivot = lo + rd.nextInt(hi - lo);
        pivot = partition(lo, hi, pivot);
        if (pivot == k) {
            return;
        } else if (pivot > k) {
            quickselect(lo, pivot - 1, k);
        } else {
            quickselect(pivot + 1, hi, k);
        }
    }
    /**
     * Time Complexity O(NLog(k)) 17ms 17.88%
     * Space Complexity O(N + k) 45.5MB 18.76%
     */
//    public int[] topKFrequent(int[] nums, int k) {
//        int[] freq = new int[k];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : nums) {
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
//        for (int n : map.keySet()) {
//            pq.add(n);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//        for (int i = k - 1; i >= 0; i--) {
//            freq[i] = pq.poll();
//        }
//        return freq;
//    }
}
