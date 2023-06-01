package M1396DesignUndergroundSystem;

import M1654MinimumJumpstoReachHome.Pair;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    private Map<Pair<String, String>, Integer> count;
    private Map<Pair<String, String>, Integer> sum;
    private Map<Integer, Pair<String, Integer>> checkin;

    public UndergroundSystem() {
        count = new HashMap<>();
        sum = new HashMap<>();
        checkin = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkin.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> in = checkin.get(id);
        String station = in.getKey();
        int time = t - in.getValue();
        Pair<String, String> key = new Pair(station, stationName);
        count.put(key, count.getOrDefault(key, 0) + 1);
        sum.put(key, sum.getOrDefault(key, 0) + time);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> key = new Pair(startStation, endStation);
        return sum.get(key) * 1.0 / count.get(key);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
