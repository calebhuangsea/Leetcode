package Weekly371;

import java.util.*;

public class Q2 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (List<String> token : access_times) {
            String name = token.get(0);
            int time = calc(token.get(1));
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(time);
        }
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            int count = 0;
            Deque<Integer> dq = new LinkedList<>();
            dq.add(times.get(0));
            for (int i = 1; i < times.size(); i++) {
                while (!dq.isEmpty() && times.get(i) - dq.peekFirst() >= 60) {
                    dq.pollFirst();
                }
                dq.add(times.get(i));
                count = Math.max(count, dq.size());
            }
            if (count >= 3) res.add(name);
        }
        return res;
    }

    private int calc(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(2));
        return h * 60 + m;
    }
}
