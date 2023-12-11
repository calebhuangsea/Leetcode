package Other.R1700;

import java.io.*;
import java.util.StringTokenizer;

public class I287B {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        long n = sc.nextLong(), k = sc.nextLong();
        if (n == 1) {
            out.println(0);
            out.close();
            return;
        } else if (k >= n) {
            out.println(1);
            out.close();
            return;
        }
        n -= 1;
        k -= 1;
        if (sum(k) < n) {
            out.println(-1);
            out.close();
            return;
        }
        long left = 1, right = k;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long s = sum(mid, k);
            if (s == n) {
                out.println(k - mid + 1);
                out.close();
                return;
            } else if (s > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        out.println(k - left + 2);
        out.close();
    }

    static long sum(long left, long right) {
        long s = 0;
        if (left <= right) {
            s = sum(right) - sum(left - 1);
        }
        return s;
    }

    static long sum(long k) {
        return k * (k + 1) / 2;
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

