package H460LFUCache;

import java.util.*;

public class LFUCache {
    /**
     * Use two map and a min to count
     * Time Complexity: O(1) 81ms 59.48%
     * Space Complexity: O(N) 129.2MB 53.19%
     */
    // key, <freq, val>
    private Map<Integer, int[]> cache;
    // freq, <keys>
    private Map<Integer, LinkedHashSet<Integer>> freq;
    private int capacity;
    // minimum frequency
    private int min;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        min = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // remove from old freq
        int[] curr = cache.get(key);
        freq.get(curr[0]).remove(key);
        // update the min if needed
        if (curr[0] == min && freq.get(min).isEmpty()) {
            min++;
        }
        // update freq of current cache
        curr[0]++;
        if (!freq.containsKey(curr[0])) {
            freq.put(curr[0], new LinkedHashSet<>());
        }
        freq.get(curr[0]).add(key);
        return curr[1];
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {// if the key is already in
            int[] curr = cache.get(key);
            // remove from old frequency
            freq.get(curr[0]).remove(key);
            // update min freq if needed
            if (curr[0] == min && freq.get(min).isEmpty()) {
                min++;
            }
            // update the freq of current cache
            curr[0]++;
            if (!freq.containsKey(curr[0])) {
                freq.put(curr[0], new LinkedHashSet<>());
            }
            // add it to new set and update value
            freq.get(curr[0]).add(key);
            curr[1] = value;
        } else {
            if (capacity == cache.size()) {
                // remove the old key
                // get key
                int rmKey = freq.get(min).iterator().next();
                // get the value
                int[] removed = cache.get(rmKey);
                // remove from freq
                freq.get(min).remove(rmKey);
                // remove from cache
                cache.remove(rmKey);
            }
            // update min
            min = 1;
            if (!freq.containsKey(min)) {
                freq.put(min, new LinkedHashSet<>());
            }
            int[] newCache = new int[] {min, value};
            cache.put(key, newCache);
            freq.get(min).add(key);
        }
    }
}
