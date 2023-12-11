package DIV2.R914;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            long a = sc.nextLong(), b = sc.nextLong();
            long xk = sc.nextLong(), yk = sc.nextLong();
            long xq = sc.nextLong(), yq = sc.nextLong();
            // king and knight are in different position, check if
            // find all possible position of knight and queens
            Set<Pair> k = new HashSet<>();
//            Set<Pair> q = new HashSet<>();
            // b, +- a
            k.add(new Pair(xk + b, yk + a));
            k.add(new Pair(xk + b, yk - a));
            k.add(new Pair(xk - b, yk + a));
            k.add(new Pair(xk - b, yk - a));
            // a, +- b
            k.add(new Pair(xk + a, yk + b));
            k.add(new Pair(xk + a, yk - b));
            k.add(new Pair(xk - a, yk + b));
            k.add(new Pair(xk - a, yk - b));
            int count = 0;
            if (k.remove(new Pair(xq + b, yq + a))) count++;
            if (k.remove(new Pair(xq + b, yq - a))) count++;
            if (k.remove(new Pair(xq - b, yq + a))) count++;
            if (k.remove(new Pair(xq - b, yq - a))) count++;
            // a, +- b
            if (k.remove(new Pair(xq + a, yq + b))) count++;
            if (k.remove(new Pair(xq + a, yq - b))) count++;
            if (k.remove(new Pair(xq - a, yq + b))) count++;
            if (k.remove(new Pair(xq - a, yq - b))) count++;




            // check if any of the position is the same as queen


            out.println(count);
        }
        out.close();
    }

    static class Pair {
        long x, y;
        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return this.x == p.x && this.y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
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

