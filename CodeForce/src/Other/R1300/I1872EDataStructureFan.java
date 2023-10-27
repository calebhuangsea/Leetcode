package Other.R1300;

import java.io.*;
import java.util.StringTokenizer;

public class I1872EDataStructureFan {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            char[] s = sc.next().toCharArray();
            long zero = 0;
            long one = 0;
            long[] pre = new long[s.length + 1];
            for (int i = 1; i <= s.length; i++) {
                if (s[i - 1] == '0') zero ^= a[i - 1];
                else one ^= a[i - 1];
                pre[i] = pre[i - 1] ^ a[i - 1];
            }
            int q = sc.nextInt();
            long common = 0;
            while (q-- > 0) {
                if (sc.nextInt() == 1) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    common = pre[r] ^ pre[l - 1];
                    one ^= common;
                    zero ^= common;
                } else {
                    out.print(sc.nextInt() == 0 ? zero : one);
                    out.print(" ");
                }
            }
            out.println();
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

