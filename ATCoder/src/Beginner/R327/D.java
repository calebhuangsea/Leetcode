package Beginner.R327;

import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            if (a[i] == b[i]) {
                out.println("No");
                out.close();
                return;
            }
            adjList.get(a[i]).add(b[i]);
            adjList.get(b[i]).add(a[i]);
        }
        int[] x = new int[n + 1];
        Arrays.fill(x, -1);
        for (int i = 1; i <= n; i++) {
            if (x[i] == -1)
                if (!dfs(adjList, x, i, 0)) {
                    out.println("No");
                    out.close();
                    return;
                }
        }

        out.println("Yes");
        out.close();
    }

    private static boolean dfs(List<List<Integer>> adjList, int[] x, int i, int v) {
        if (x[i] != -1) return x[i] == v;
        x[i] = v;
        boolean flag = true;
        for (int j : adjList.get(i)) {
            flag &= dfs(adjList, x, j, v ^ 1);
        }
        return flag;
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

