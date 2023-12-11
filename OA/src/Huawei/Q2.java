package Huawei;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) levels[i] = in.nextInt();
        int m = in.nextInt();
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int l = in.nextInt(), r = in.nextInt();
            adj[l].add(r);
            adj[r].add(l);
        }
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                max = Math.max(dfs(levels, adj, visited, i), max);
            }
        }
        System.out.println(max);
    }

    private static int dfs(int[] levels, List<Integer>[] adj, Set<Integer> visited, int curr) {
        int sum = 1;
        for (int nei : adj[curr]) {
            if (!visited.contains(nei) && levels[nei] == levels[curr]) {
                visited.add(nei);
                sum += dfs(levels, adj, visited, nei);
            }
        }
        return sum;
    }

}
//8 1 1 2 2 2 2 2 2 5 0 1 2 3 4 5 5 6 6 7
