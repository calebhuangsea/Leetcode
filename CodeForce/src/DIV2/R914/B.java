package DIV2.R914;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                b[i] = a[i];
            }
            // greedy, cumulatively take previous and see how far we can get to
            long sum = 0;
            int i = 0;
            int start = 0;
            Arrays.sort(b);
            Map<Long, Integer> map = new HashMap<>();
            while (i < n) {
                sum += b[i];
                while (sum < 0 || i + 1 < n && sum >= b[i + 1]) {
                    i++;
                    sum += b[i];
                }
                for (int j = start; j <= i; j++) {
                    map.put(b[j], i);
                }
                start = i + 1;
                i++;
            }
            for (int j = 0; j < n; j++) {
                out.print(map.get(a[j]) + " ");
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

