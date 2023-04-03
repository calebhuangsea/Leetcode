package H295FindMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * lts: large to small pq, when odd this holds k / 2 + 1, when even, it holds k / 2
 * stl: small to large pq, when odd or even this holds k / 2
 * Time Complexity add: O(log(N)) find: O(1) 140ms 48.92%
 * Space Complexity O(N) 61.8MB 50.77%
 */
public class MedianFinder {
    PriorityQueue<Integer> lts = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> stl = new PriorityQueue<Integer>();
    boolean even = true;

    public void addNum(int num) {
        if (even) {
            stl.add(num);
            lts.add(stl.poll());
        } else {
            lts.add(num);
            stl.add(lts.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return 1.0 * (stl.peek() + lts.peek()) / 2;
        } else {
            return lts.peek();
        }
    }
}