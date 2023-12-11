package Other.R1600;

import java.io.*;
import java.util.*;

public class I369CValeraandElections {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1, t = sc.nextInt();
            adj[x].add(new int[] {y, t});
            adj[y].add(new int[] {x, t});
        }
        Set<Integer> v = new HashSet<>();
        v.add(0);
        List<Integer> res = new ArrayList<>();
        dfs(adj, 0, v, res, false);
        out.println(res.size());
        for (int node : res) {
            out.print(node + " ");
        }
        out.close();
    }
    // in each node, we calculate the cumulative so far, and the cost for each sub-node
    private static boolean dfs(List<int[]>[] adj, int curr, Set<Integer> visited, List<Integer> res, boolean last) {
        boolean sub = false;
        for (int[] nei : adj[curr]) {
            if (!visited.contains(nei[0])) {
                visited.add(nei[0]);
                sub |= dfs(adj, nei[0], visited, res, nei[1] == 2);
            }
        }
        // if sub is all false but last is true, we add this
        if (!sub && last) {
            res.add(curr + 1);
        }
        return last | sub;
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

