package DIV2.R907;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 2];
            a[0] = Integer.MIN_VALUE;
            a[n + 1] = Integer.MAX_VALUE;
            for (int i=1; i<=n; i++) {
                a[i] = sc.nextInt();
            }
            // find the largest m such that 2^m <= n
            int m = 1;
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                if (m < i) {
                    m *= 2;
                }
                if (a[i] > a[i + 1] && i != m) {
                    out.println("NO");
                    flag = false;
                    break;
                }
            }
            if (flag) out.println("YES");
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

