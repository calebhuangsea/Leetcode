package EDUC.R158;

import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] l = new int[n], r = new int[n];//l[i] = 初始位置在 i 左边，它的所需最大值
        int lmax = 0, rmax = 0;
        for (int i = 0; i < n; i++) {
            l[i] = a[i] + i;
            lmax = Math.max(lmax, l[i]);
        }
        for (int i = 0; i < n; i++) {
            r[i] = a[i] + n - i - 1;
            rmax = Math.max(rmax, r[i]);
        }
        int[] ml = new int[n + 1], mr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            ml[i] = Math.max(ml[i + 1], l[i]);
        }
        for (int i = 1; i <= n; i++) {
            mr[i] = Math.max(mr[i - 1], r[i - 1]);
        }
        int ans = (int) 2e9;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(a[i], Math.max(ml[i + 1], mr[i])));
        }

        System.out.println(ans);
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

