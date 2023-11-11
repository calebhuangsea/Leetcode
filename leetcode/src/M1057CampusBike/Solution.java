package M1057CampusBike;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        // index,
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            int comp = Integer.compare(a[0], b[0]);
            if (comp == 0) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
            return comp;
        });

        for (int i = 0; i < n; i++) {
            int x1 = workers[i][0];
            int y1 = workers[i][1];
            for (int j = 0; j < m; j++) {
                int x2 = bikes[j][0];
                int y2 = bikes[j][1];
                int sum = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                q.add(new int[] {sum, i, j});
            }
        }
        int count = 0;
        int[] w = new int[n];
        int[] b = new int[m];
        Arrays.fill(w, -1);
        Arrays.fill(b, -1);
        while (count < n && !q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[1], j = arr[2];
            if (w[i] == -1 && b[j] == -1) {
                w[i] = j;
                b[j] = i;
            }
        }
        return w;
    }
}
