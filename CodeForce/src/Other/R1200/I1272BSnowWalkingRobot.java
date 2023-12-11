package Other.R1200;

import java.io.*;
import java.util.StringTokenizer;

public class I1272BSnowWalkingRobot {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int l = 0, r = 0, u = 0, d = 0;
            String line = sc.nextLine();
            for (char c : line.toCharArray()) {
                if (c == 'L') l++;
                if (c == 'R') r++;
                if (c == 'U') u++;
                if (c == 'D') d++;

            }
            int x = Math.min(u, d);
            int y = Math.min(l, r);
            if (x == 0 && y == 0) {
              out.println(0 + "\n");
            } else if (x == 0) {
                out.println(2);
                out.println("LR");
            } else if (y == 0) {
                out.println(2);
                out.println("UD");
            } else {
                out.println(x * 2 + y * 2);
                for (int i = 0; i < x; i++) {
                    out.print("U");
                }
                for (int i = 0; i < y; i++) {
                    out.print("L");
                }
                for (int i = 0; i < x; i++) {
                    out.print("D");
                }
                for (int i = 0; i < y; i++) {
                    out.print("R");
                }
                out.println();
            }
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

