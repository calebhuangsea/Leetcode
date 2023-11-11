package Beginner.R327;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("4", "2");
        map.put("27", "3");
        map.put("256", "4");
        map.put("3125", "5");
        map.put("46656", "6");
        map.put("823543", "7");
        map.put("16777216", "8");
        map.put("387420489", "9");
        map.put("10000000000", "10");
        map.put("285311670611", "11");
        map.put("8916100448256", "12");
        map.put("302875106592253", "13");
        map.put("11112006825558016", "14");
        map.put("437893890380859375", "15");
        System.out.println(map.getOrDefault(sc.next(), "-1"));
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

