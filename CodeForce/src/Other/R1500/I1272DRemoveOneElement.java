package Other.R1500;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I1272DRemoveOneElement {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i= 0; i < n; i++) a[i] = sc.nextInt();
        int[] pre = new int[n];
        Arrays.fill(pre, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) pre[i] += pre[i - 1];
            max = Math.max(pre[i], max);
        }
        int[] suf = new int[n];
        Arrays.fill(suf, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) suf[i] += suf[i + 1];
            max = Math.max(suf[i], max);
        }
        for (int i = 1; i < n - 1; i++) {
            if (a[i - 1] < a[i + 1]) {
                max = Math.max(max, pre[i - 1]+ suf[i + 1]);
            }
        }
        out.println(max);
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

