package DIV2.R906;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            boolean tt = true;
            for (int i = 1; i < m; i++) {
                if (t.charAt(i) == t.charAt(i - 1)) {
                    tt = false;
                    break;
                }
            }
            boolean ss = true;
            for (int i = 1; i < n && ss; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    if (!tt || s.charAt(i) == t.charAt(m - 1) || s.charAt(i - 1) == t.charAt(0)) {
                        ss = false;
                    }
                }
            }
            if (ss) out.println("YES");
            else out.println("NO");
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

