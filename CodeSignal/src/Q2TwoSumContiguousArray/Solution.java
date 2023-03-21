package Q2TwoSumContiguousArray;

/**
 * Given an array of integers a, your task is to find how many of its contiguous subarrays of length m contain a pair of integers with a sum equal to k.
 * <p>
 * More formally, given the array a, your task is to count the number of indices 0 ≤ i ≤ a.length - m such that a subarray [a[i], a[i + 1], ..., a[i + m - 1]] contains at least one pair (a[s], a[t]), where:
 * <p>
 * s ≠ t
 * a[s] + a[t] = k
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    int solution(int[] a, int m, int k) {
        // keep track of how many times each element has appeared
        Map<Integer, Integer> map = new HashMap<>();
        // keep track of the product of a valid sum(make them unique), use long to avoid integer overflow
        Set<Long> set = new HashSet<>();
        // deal with the first contiguous subarray
        for (int i = 0; i < m; i++) {
            if (map.containsKey(k - a[i])) {//if we find a pair, add it to the set
                set.add((long)a[i] * (k - a[i]));
            }
            // update the map
            if (!map.containsKey(a[i])) {
                map.put(a[i], 0);
            }
            map.put(a[i], map.get(a[i]) + 1);
        }
        // initialize count, if there appear some valid pair in the first subarray or not
        int count = set.size() > 0 ? 1 : 0;
        // the index of element that we want to remove when we are moving to the next subarray
        int removeIdx = 0;
        for (int i = m; i < a.length; i++) {
            if (map.get(a[removeIdx]) == 1) {// if this is the only element, we remove every pair in the set
                map.remove(a[removeIdx]);
                set.remove((long)a[removeIdx] * (k - a[removeIdx]));
            } else {//this is not the only element, after we remove it we need to check too
                map.put(a[removeIdx], map.get(a[removeIdx]) - 1);
                if (map.get(a[removeIdx]) == 1 && 2 * a[removeIdx] == k) {
                    // if there is only one element left after we remove it and it form a pair
                    // because if there is not only one left, we don't need to do anything
                    // because the rest of this integer can still form pair with existing integers
                    set.remove((long)a[removeIdx] * a[removeIdx]);
                }
            }
            removeIdx++;
            if (map.containsKey(k - a[i])) {
                set.add((long) (k - a[i]) * a[i]);
            }
            count += set.size() > 0 ? 1 : 0;
            // update the map
            if (!map.containsKey(a[i])) {
                map.put(a[i], 0);
            }
            map.put(a[i], map.get(a[i]) + 1);
        }
        return count;
    }
}
