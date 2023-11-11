package EDUC.R157;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[2*n];
            for (int i = 0; i < 2*n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int l = 0, r = a.length - 1;
            int diff = 0;
            Stack<int[]> s = new Stack<>();
            while (l < r) {
                if (!s.isEmpty()) {
                    diff += Math.abs(s.peek()[0] - a[l]) + Math.abs(s.peek()[1] - a[r]);
                }
                s.add(new int[] {a[l++], a[r--]});
            }
            out.println(diff);
            for (int[] ss : s) {
                out.println(ss[0] + " " + ss[1]);
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

