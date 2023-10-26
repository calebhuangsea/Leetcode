package Other.R1600;

import java.io.*;
import java.util.StringTokenizer;

public class I750CNewYearAndRating {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param args
     */
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int s = 0;
        int minR = Integer.MIN_VALUE;
        int maxR = Integer.MAX_VALUE;
        int c, d;
        for (int i = 1; i <= n; i++) {
            c = sc.nextInt();
            d = sc.nextInt();
            if (d == 1) {
                minR = Math.max(minR, 1900 - s);
            } else {
                maxR = Math.min(maxR, 1899 - s);
            }
            s += c;
        }
        if (minR > maxR) {
            out.println("Impossible");
        } else if (maxR == Integer.MAX_VALUE) {
            out.println("Infinity");
        } else {
            out.println(maxR + s);
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

