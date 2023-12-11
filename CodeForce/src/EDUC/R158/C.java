package EDUC.R158;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i=0; i<n; i++) {
                set.add(sc.nextInt());
            }
            int d = -1;
            int max = 0;
            for (int num : set) {
                if (d == -1) {
                    d = num;
                    continue;
                }
                int count = 0;
                while (num != d) {
                    num = (num + d) / 2;
                    count++;
                }
                max = Math.max(max, count);
            }
            out.println(max);
            if (max <= n) {
                for (int i=0; i<max; i++) {
                    out.print(d + " ");
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

