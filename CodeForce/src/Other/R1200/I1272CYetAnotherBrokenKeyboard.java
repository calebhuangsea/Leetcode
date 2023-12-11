package Other.R1200;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class I1272CYetAnotherBrokenKeyboard {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int l = sc.nextInt();
        int n = sc.nextInt();
        String line = sc.next();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next().charAt(0));
        }
        int start = 0;
        long res = 0;
        long count = 0;
        for (int i = 0; i < l; i++) {
            char c = line.charAt(i);
            if (set.contains(c)) {
                count++;
            } else {
                res += count * (count + 1) / 2;
                count = 0;
            }
        }
        res += count * (count + 1) / 2;
        out.println(res);
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

