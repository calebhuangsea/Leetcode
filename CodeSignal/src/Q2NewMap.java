import java.util.*;

public class Q2NewMap {
    long solution(String[] queryType, int[][] query) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        int ck = 0;
        int cv = 0;
        for (int i = 0; i < queryType.length; i++) {
            int[] q = query[i];
            String type = queryType[i];
            if (type.equals("insert")) {
                map.put(q[0] - ck, q[1] - cv);
            } else if (type.equals("addToValue")) {
                cv += q[0];
            } else if (type.equals("addToKey")) {
                ck += q[0];
            } else if (type.equals("get")) {
                sum += map.get(q[0] - ck) + cv;
            }
        }
        return sum;
    }

}
