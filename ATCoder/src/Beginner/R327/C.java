package Beginner.R327;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int[][] a  = new int[9][9];
        Set<Integer>[] rows = new Set[9];
        Set<Integer>[] cols = new Set[9];
        Set<Integer>[] boxes = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j] = sc.nextInt();
                rows[i].add(a[i][j]);
                cols[j].add(a[i][j]);
                boxes[(i / 3) * 3 + j / 3].add(a[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (rows[i].size() != 9 || cols[i].size() != 9 || boxes[i].size() != 9) {
                out.println("No");
                out.close();
                return;
            }
        }
        out.println("Yes");
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

