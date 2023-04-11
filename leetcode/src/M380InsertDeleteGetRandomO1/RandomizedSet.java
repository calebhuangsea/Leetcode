package M380InsertDeleteGetRandomO1;

import java.util.*;

/**
 * Time Complexity O(1)
 * Space Complexity O(N)
 */
public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int last = list.get(list.size() - 1);
        int rmIndex = map.get(val);
        list.set(rmIndex, last);
        list.remove(list.size() - 1);
        map.put(last, rmIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
