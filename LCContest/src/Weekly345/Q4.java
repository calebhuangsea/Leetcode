package Weekly345;
import Biweekly104.A;

import java.util.*;
public class Q4 {
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        //
        int[][] arr = new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(countCompleteComponents(6, arr));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        int[][] adj = new int[n][n];
        int[] degree = new int[n];
        for (int[] e : edges) {
            adj[e[0]][e[1]] = 1;
            adj[e[0]][e[0]] = 1;
            adj[e[1]][e[1]] = 1;
            adj[e[1]][e[0]] = 1;
            degree[e[1]]++;
            degree[e[0]]++;
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            if (degree[i] == 0) {
                count++;
                continue;
            }
            boolean flag = true;
            for (int nei = 0; nei < n && flag; nei++) {
                if (nei != i && adj[i][nei] == 1) {
                    set.add(nei);
                    for (int j = 0; j < n; j++) {
                        if (adj[i][j] != adj[nei][j]) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}



