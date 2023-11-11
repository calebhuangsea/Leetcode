package DIV2.R906;

import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            if (map.keySet().size() > 2) out.println("No");
            else if (map.keySet().size() == 1) out.println("Yes");
            else {
                int n1 = -1, n2 = -1;
                for (int key : map.keySet()) {
                    if (n1 == -1) n1 = map.get(key);
                    else n2 = map.get(key);
                }
                if (Math.abs(n1 - n2) <= 1) out.println("Yes");
                else out.println("No");
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

