package Other.R1300;

import java.io.*;
import java.util.*;

public class I1870CColorfulTable {
    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = in.nextInt();
        for(int test=1;test<=t;test++)
        {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n;i++) a[i] = in.nextInt();
            for(int i=0;i<n;i++)
                a[i]--;

            int[] hd = new int[k];
            int[] nxt = new int[n];
            Arrays.fill(hd, -1);
            for(int i=0;i<n;i++)
            {
                nxt[i] = hd[a[i]];
                hd[a[i]] = i;
            }

            int minx = Integer.MAX_VALUE;
            int maxx = Integer.MIN_VALUE;

            int[] ans = new int[k];

            for(int i=k-1;i>=0;i--)
            {
                for(int e = hd[i]; e!=-1; e=nxt[e])
                {
                    minx = Math.min(minx, e);
                    maxx = Math.max(maxx, e);
                }
                if(hd[i] != -1)
                {
                    ans[i] = 2*(maxx-minx+1);
                }
            }
            for (int num : ans) {
                out.print(num + " ");
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

