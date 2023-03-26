package Weekly338;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q6356 {
    class Node {
        int val;
        int coin;
        List<Node> next;
        public Node(int v, int c) {
            val = v;
            coin = c;
            next = new ArrayList<>();
        }
    }

    private List<Node> ls = new ArrayList<>();

    public int collectTheCoins(int[] coins, int[][] edges) {
        for (int i = 0; i < coins.length; i++) {
            ls.add(new Node(i, coins[i]));
        }
        for (int[] edge : edges) {
            ls.get(edge[0]).next.add(ls.get(edge[1]));
            ls.get(edge[1]).next.add(ls.get(edge[0]));
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            min = Math.min(rec(i, visited), min);
        }
        return min;
    }

    private int rec(int curr, Set<Integer> visited) {
        if (visited.size() == ls.size()) {
            return 0;
        }
        return -1;
    }
}
