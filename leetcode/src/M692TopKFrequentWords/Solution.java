package M692TopKFrequentWords;

import java.util.*;

public class Solution {
    /**
     * Time: O(N log(N))
     * Space: O(N)
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ls = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1)
        );
        for (String key : map.keySet()) {
            pq.offer(key);
        }
        for (int i = 0; i < k; i++) {
            ls.add(pq.poll());
        }
        return ls;
    }
}
