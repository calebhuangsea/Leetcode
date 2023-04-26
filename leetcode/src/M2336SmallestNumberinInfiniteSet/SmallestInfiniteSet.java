package M2336SmallestNumberinInfiniteSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SmallestInfiniteSet {
    int cur;
    Set<Integer> s;

    public SmallestInfiniteSet() {
        cur = 1;
        s = new HashSet<>();
    }

    public int popSmallest() {
        if (!s.isEmpty()) {
            int res = Collections.min(s);
            s.remove(res);
            return res;
        } else {
            cur++;
            return cur - 1;
        }
    }

    public void addBack(int num) {
        if (cur > num) {
            s.add(num);
        }
    }
}
