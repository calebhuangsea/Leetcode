package Other.R900;

import java.io.*;
import java.util.StringTokenizer;

public class I1272AThreeFriends {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            long res = Long.MAX_VALUE;
            for (int i = a - 1; i <= a + 1; i++) {
                for (int j = b - 1; j <= b + 1; j++) {
                    for (int z = c - 1; z <= c + 1; z++) {
                        res = Math.min(res, Math.abs(i - j) + Math.abs(i - z) + Math.abs(j - z));
                    }
                }
            }
            out.println(res);
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

