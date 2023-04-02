package Weekly339;

import java.util.*;

public class Q2 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // count occurrence of each number in the array
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            count = Math.max(count, map.get(n));
        }
        for (int i = 0; i < count; i++) {
            result.add(new ArrayList<>());
        }
        for (int key : map.keySet()) {
            int times = map.get(key);
            for (int i = 0; i < times; i++) {
                result.get(i).add(key);
            }
        }
        return result;
    }
}
