package weekly373;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2));
    }

    /**
     * Notice that if we have 5, 3, 1, we can apply operations so to obtain 1, 3, 5
     * We can group numbers by intervals, after sorted, subarray 1, 3, 5 have intervals that <= limit
     * then we can say that they are in the same group, and if we met any one of them when iterating through
     * the original array, we can always use the smallest one from the group to obtain the lexicographically smallest array
     *
     *
     */
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        // if interval is within limit, then we can swap them without constraint
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Map<Integer, Integer> ht = new HashMap<>();
        int index = 0;
        map.put(index, new LinkedList<>());
        map.get(index).add(copy[0]);
        ht.put(copy[0], index);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] - copy[i - 1] <= limit) {
                map.get(index).add(copy[i]);
                ht.put(copy[i], index);
            } else {
                index++;
                map.put(index, new LinkedList<>());
                map.get(index).add(copy[i]);
                ht.put(copy[i], index);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index = ht.get(nums[i]);
            Queue<Integer> q = map.get(index);
            res[i] = q.poll();
        }
        return  res;
    }
}
