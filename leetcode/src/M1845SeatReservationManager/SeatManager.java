package M1845SeatReservationManager;

import java.util.PriorityQueue;

public class SeatManager {
    // boolean[] s;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatManager(int n) {
        // s = new boolean[n];
        for (int i = 1; i <= n; i++) pq.add(i);
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
