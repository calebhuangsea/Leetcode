package EDUC.R157;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = in.nextInt();
        String[] arr = new String[n];
        int[] pre = new int[n];
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            arr[i] = in.next();
            int sum = 0;
            for ( int j = 0; j < arr[i].length(); j++) sum += (arr[i].charAt(j)-'0');
            map.putIfAbsent(sum, new int[5]);
            int[] temp = map.get(sum);
            temp[arr[i].length()-1]++;
            pre[i] = sum;
        }
        long ans = 0;
        for ( int i = 0; i < n; i++){
            int now = 0;
            for ( int j = 0; j < arr[i].length(); j++){
                now += arr[i].charAt(j) - '0';
                int rem = pre[i]- now;
                int[] temp = new int[5];
                int remsize = arr[i].length() - (j+1);
                if (now > rem){
                    int diff = now-rem;
                    int size = (j+1) - remsize;
                    if (size <= 0) continue;
                    if (map.containsKey(diff)) temp = map.get(diff);
                    ans += temp[size-1];
                } else if (rem > now){
                    int diff = rem-now;
                    int size = remsize - (j+1);
                    if (size <= 0) continue;
                    if (map.containsKey(diff)) temp = map.get(diff);
                    ans += temp[size-1];
                }
            }
        }
        out.println(ans);
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

