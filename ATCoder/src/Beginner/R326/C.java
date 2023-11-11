package Beginner.R326;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = -1;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int target = a[i] + m;
            // binary search to find insert position
            int l = i, r = n - 1;
            while (l <= r) {
                int mid =l + (r - l) / 2;
                if (a[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            max = Math.max(max, l - i);
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

