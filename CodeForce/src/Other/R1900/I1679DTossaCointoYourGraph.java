package Other.R1900;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class I1679DTossaCointoYourGraph {
    static int N;
    static int M;
    static int K;
    static int[] a;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        N = sc.nextInt();
        M = sc.nextInt();
        K = (int)Math.min(1000000000, sc.nextLong());
        a = new int[N];
        for (int i = 0; i < N; i++) a[i] = sc.nextInt();
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph[u - 1].add(v - 1);
        }
        int lo = 0, hi = 1000000000, mid = 0, ans = -1;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(works(mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        out.println(ans);
        out.close();
    }

    private static boolean works(int x) {
        int[] dp = new int[N], in = new int[N];
        for (int i = 0; i < N; i++) {
            if (a[i] <= x) {
                for (int nei : graph[i]) {
                    if (a[nei] <= x) {
                        in[nei]++;
                    }
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (a[i] <= x && in[i] == 0) {
                q.add(i);
                dp[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (a[nei] <= x) {
                    dp[nei] = Math.max(dp[nei], dp[cur] + 1);
                    in[nei]--;
                    if (in[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (in[i] != 0 || dp[i] >= K) return true;
        }
        return false;
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

