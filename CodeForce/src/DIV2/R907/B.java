package DIV2.R907;

import java.io.*;
import java.util.*;

public class B {


//            HashSet<Integer> set = new HashSet<>();
//            for ( int i =0; i < x; i++){
//                int k = in.nextInt();
//                if (set.add(k)){
//                    for ( int j = 0; j < n; j++){
//                        if (a[j] % (int) Math.pow(2,k) == 0) a[j] += (int) Math.pow(2,k-1);
//                    }
//                }
//            }
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt(), q = sc.nextInt();
            long[] a = new long[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            for (int i=0; i<q; i++) {
                int k = sc.nextInt();
                if (set.add(k)) {
                    for (int j = 0; j < n; j++) {
                        if (a[j] % (int) Math.pow(2, k) == 0) a[j] += (int) Math.pow(2, k - 1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(a[i] + " ");
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

