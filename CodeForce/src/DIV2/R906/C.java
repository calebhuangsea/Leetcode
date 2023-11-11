package DIV2.R906;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            if (n % 2 == 1) {
                out.println(-1);
                continue;
            }
            List<Integer> ls = new ArrayList<>();
            int count = 0;
            int l = 0, r = n - 1;
            while (l < r && count <= 300) {
                if (s.charAt(l) != s.charAt(r)) {
                    l++;
                    r--;
                } else {
                    // we try to insert 01 into somewhere
                    //l == r now, we want to make l != new r
                    if (s.charAt(l) == '0') {
                        // we can insert 01 behind r
                        s = s.substring(0, r + 1) + "01" + s.substring(r + 1);
                        ls.add(r + 1);
                        count++;
                        l++;
                        r++;
                    } else if (s.charAt(l) == '1') {
                        // we can insert 01 before l
                        s = s.substring(0, l) + "01" + s.substring(l);
                        ls.add(l);
                        count++;
                        l++;
                        r++;
                    } else {
                        count = 301;
                    }
                }
            }
            if (count > 300) out.println(-1);
            else {
                out.println(count);
                for (int i = 0; i < count; i++) {
                    out.print(ls.get(i) + " ");
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

