package DIV4.R871;

import java.util.*;

public class G {
    public static void main(String[] args) {
//        System.out.println(6236211665544623022l < 58116199242129511l);
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int z = 0; z < lines; z++) {
            int hit = sc.nextInt();
            // find the level of hit and recursively go up, do bfs
            int l = level(hit);
            long sum = 0;
            Set<Integer> visited = new HashSet<>();
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {hit, l});
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int can = curr[0];
                int level = curr[1];
                sum += (long)can * (long)can;
                int left = can - level;
                int right = can - level + 1;
                int next = level - 1;
                if (!visited.contains(left) && left >= (next * (next + 1)) / 2 - next + 1) {
                    q.add(new int[] {left, next});
                    visited.add(left);
                }
                if (!visited.contains(right) && right <= (next * (next + 1)) / 2) {
                    visited.add(right);
                    q.add(new int[] {right, next});
                }
            }
            System.out.println(sum);
        }
    }

    private static int level(int hit) {
        int lo = 0;
        int hi = hit / 2 + 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long levelMax = ((long)mid * (long)(mid + 1)) / 2;
            if (hit > levelMax) {
                lo = mid + 1;
            } else if (hit < levelMax - mid + 1) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
