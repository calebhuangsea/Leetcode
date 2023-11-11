package Other.R1400;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class I26BRegularBracketSequence {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        char[] cc = sc.next().toCharArray();
        Stack<Character> s = new Stack<>();
        int count = 0;
        for (char c : cc) {
            if (s.isEmpty()) {
                if (c != ')') s.push(c);
            } else {
                if (c == '(') s.push(c);
                else {
                    s.pop();
                    count += 2;
                }
            }
        }
        out.println(count);
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

