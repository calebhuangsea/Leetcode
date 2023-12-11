package Other.R2100;

import java.io.*;
import java.util.*;

public class I1271DPortals {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int con = 5000; // maximum warriors
        // number of castles, number of portals, initial warrios number
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[][] dp = new int[n][con + 1]; // dp[i][c] means that after conquered the ith castle with c warriors left, our value
        for (int[] d : dp) Arrays.fill(d, -1);
        int[][] castles = new int[n][3]; // cost, gain, value
        for (int i = 0; i < n; i++) {
            castles[i][0] = sc.nextInt();
            castles[i][1] = sc.nextInt();
            castles[i][2] = sc.nextInt();
        }
        int[][] path = new int[m][2];
        for (int i = 0; i < m; i++) {
            // from u to v
            path[i][0] = sc.nextInt() - 1;
            path[i][1] = sc.nextInt() - 1;
        }
        // we want the latest portal, optimal
        Arrays.sort(path, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            else return Integer.compare(b[0], a[0]);
        });
        Set<Integer> skip = new HashSet<>();
        Map<Integer, List<Integer>> portals = new HashMap<>();
        for (int[] p : path) {
            if (skip.add(p[1])) {
                if (!portals.containsKey(p[0])) portals.put(p[0], new ArrayList<>());
                portals.get(p[0]).add(p[1]);
            }
        }
        if (k < castles[0][0]) { // if we can't even get through the first castle
            out.println(-1);
            out.close();
            return;
        }
        // initialize the first castle
        dp[0][k + castles[0][1]] = 0;
        // if there is no portal to go back to this one and we have enough warriors
        if (!skip.contains(0) && k + castles[0][1] - 1 >= 0) {
            dp[0][k + castles[0][1] - 1] = castles[0][2];
        }
        for (int i = 1; i < n; i++) {
            // case if we don't defend
            // start from castles[i][0] since we need this amount to be able to take down this castle, to j <= con - castles since we want to be able to  store extra warriors
            for (int j = castles[i][0]; j <= con - castles[i][1]; j++) {
                if (dp[i - 1][j] != -1) {
                    dp[i][j + castles[i][1]] = dp[i - 1][j];
                }
            }
            if (!skip.contains(i)) {
                // if we can choose to defend this
                // start from either 1 to avoid index out of boundary or castles[i][0] + castles[i][1], total warriors we might have
                for (int j = Math.max(1, castles[i][0] + castles[i][1]); j <= con; j++) {
                    if (dp[i][j] != -1) {
                        dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + castles[i][2]);
                    }
                }
            }
            // if we choose to portal
            for (Integer por : portals.getOrDefault(i, new ArrayList<>())) {
                for (int j = 1; j <= con; j++) {
                    if (dp[i][j] != -1) {
                        dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + castles[por][2]);
                    }
                }
            }
        }

        out.println(Arrays.stream(dp[n - 1]).max().getAsInt());
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

