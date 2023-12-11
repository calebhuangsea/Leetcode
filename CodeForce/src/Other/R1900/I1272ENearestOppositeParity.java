package Other.R1900;

import java.io.*;
import java.util.*;

public class I1272ENearestOppositeParity {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        // dp[i][0]: steps needed from i to an even parity
        // dp[i][1]: steps needed from i to an odd parity
        int[][] dp = new int[n][2];
        int[] arr = new int[n];
        Deque<Integer> oq = new ArrayDeque<>();
        Deque<Integer> eq = new ArrayDeque<>();
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                eq.addLast(i);
            } else {
                oq.addLast(i);
            }
            if (i - arr[i] >= 0) {
                adj[i - arr[i]].add(i);
            }
            if (i + arr[i] < n) {
                adj[i + arr[i]].add(i);
            }
            dp[i][arr[i] % 2] = 0;
        }
        // handle odds
        while (!oq.isEmpty()) {
            int i = oq.pollFirst();
            // try bfs two side
            for (int nei : adj[i]) {
                // try to update even as well
                if (dp[nei][1] > dp[i][1] + 1) {
                    dp[nei][1] = dp[i][1] + 1;
                    oq.offerLast(nei);
                }
            }
        }
        // handle evens
        while (!eq.isEmpty()) {
            int i = eq.pollFirst();
            // try bfs two side
            for (int nei : adj[i]) {
                if (dp[nei][0] > dp[i][0] + 1) {
                    dp[nei][0] = dp[i][0] + 1;
                    eq.offerLast(nei);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) out.print(dp[i][1] == Integer.MAX_VALUE ? -1 : dp[i][1]);
            else out.print(dp[i][0] == Integer.MAX_VALUE ? -1 : dp[i][0]);
            out.print(" ");
        }
        out.close();
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

