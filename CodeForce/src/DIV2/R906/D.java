package DIV2.R906;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(), c = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        Arrays.sort(a);
        UnionFind uf = new UnionFind(n, a);
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i-1] <= c) uf.union(i, i-1);
            else break;
        }
        out.close();
    }

    static class UnionFind {
        private int[] parent;
        private long[] rank;

        // Initialize an empty union-find data structure with N items
        public UnionFind(int N, long[] ranks){
            parent = new int[N];
            rank = new long[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i] = ranks[i];
            }
        }

        // Returns the representative of the set containing item x
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // path compression
            }
            return parent[x];
        }

        // Joins the sets represented by items x and y
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        // Checks if two items belong to the same set
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

// Usage:
// UnionFind uf = new UnionFind(10);
// uf.union(1, 2);
// System.out.println(uf.isConnected(1, 2)); // true




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

