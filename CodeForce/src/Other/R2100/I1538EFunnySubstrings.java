package Other.R2100;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class I1538EFunnySubstrings {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            Map<String, Datum> map = new HashMap<>();
            String last = "";
            for (int i = 0; i < n; i++) {
                String command = sc.nextLine();
                if (command.contains(":")) {
                    String key = command.substring(0, command.indexOf(':') - 1);
                    String value = command.substring(command.indexOf('=') + 2);
                    long h = count(value.toCharArray());
                    map.put(key, new Datum(value,
                            h,
                            value.length() < 3 ? value : value.substring(0, 3),
                            value.length() < 3 ? value : value.substring(value.length() - 3)));
                    last = key;
                } else {
                    String key = command.substring(0, command.indexOf('=') - 1);
                    String a = command.substring(command.indexOf('=') + 2, command.indexOf('+') - 1);
                    String b = command.substring(command.indexOf('+') + 2);
                    Datum A = map.get(a), B = map.get(b);
                    long nh = A.h + B.h;
                    if(A.suf.endsWith("hah") && B.pre.startsWith("a"))nh++;
                    if(A.suf.endsWith("ha") && B.pre.startsWith("ha"))nh++;
                    if(A.suf.endsWith("h") && B.pre.startsWith("aha"))nh++;

                    String cpre = A.pre + B.pre;
                    if(cpre.length() > 3) cpre = cpre.substring(0, 3);
                    String csuf = A.suf + B.suf;
                    if(csuf.length() > 3) csuf = csuf.substring(csuf.length()-3);

                    Datum C = new Datum(key, nh, cpre, csuf);
                    map.put(key, C);
                    last = key;
                }
            }
            out.println(map.get(last).h);
        }
        out.close();
    }

    static long count(char[] s)
    {
        int n = s.length;
        long ct = 0;
        for(int i = 0;i+3 < n;i++){
            if(s[i] == 'h' && s[i+1] == 'a' && s[i+2] == 'h' && s[i+3] == 'a'){
                ct++;
            }
        }
        return ct;
    }

    static class Datum {
        String name;
        long h;
        String pre;
        String suf;
        public Datum(String name, long h, String pre, String suf) {
            this.name = name;
            this.h = h;
            this.pre = pre;
            this.suf = suf;
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

