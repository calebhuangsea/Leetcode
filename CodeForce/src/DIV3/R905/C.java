package DIV3.R905;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int t = 0; t < times; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int step = k;
            for (int i = 0; i < n; i += 1) {
                int nxt = sc.nextInt();
                if (nxt % k == 0) {
                    step = 0;
                }
                pq.add(nxt % 2);
                step = Math.min(step, k - nxt % k);
            }
            if (k == 4) {
                // edge case
                int two = Integer.MAX_VALUE;
                if (pq.size() >= 2) {
                    two = pq.poll() + pq.poll();
                }
                System.out.println(Math.min(step, two));
                continue;
            }
            System.out.println(step);
        }
    }
}
