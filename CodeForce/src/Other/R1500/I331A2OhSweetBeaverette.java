package Other.R1500;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class I331A2OhSweetBeaverette {
    static int n, i, j, k, ll, rr, tot;
    static int[] c = new int[300005];
    static long ans, tmp;

    static HashMap<Integer, Integer> l = new HashMap<>();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        n = sc.nextInt();
        int[] a = new int[n + 1];
        long[] sum = new long[n + 1];
        for(i = 1; i <= n; ++i) {
            a[i] = sc.nextInt();
        }

        ans = Long.MIN_VALUE; // long literal in Java ends with L
        for(i = 1; i <= n; ++i) {
            if(a[i] > 0) {
                sum[i] = sum[i-1] + a[i];
            } else {
                sum[i] = sum[i-1];
            }

            if(l.containsKey(a[i])) {
                tmp = sum[i-1] - sum[l.get(a[i])];
                tmp += a[i] * 2;
                if(tmp > ans) {
                    ans = tmp;
                    ll = l.get(a[i]);
                    rr = i;
                }
            } else {
                l.put(a[i], i);
            }
        }

        tot = 0; // Reset the tot
        for(i = 1; i < ll; ++i) c[++tot] = i;
        for(i = ll + 1; i < rr; ++i) if(a[i] < 0) c[++tot] = i;
        for(i = rr + 1; i <= n; ++i) c[++tot] = i;

        out.println(ans + " " + tot);
        for(i = 1; i <= tot; ++i) {
            out.print(c[i] + " ");
        }
        out.println();
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
