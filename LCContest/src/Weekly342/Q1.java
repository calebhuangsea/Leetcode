package Weekly342;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {

    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int diff = arrivalTime + delayedTime;
        return diff % 24;
    }
}
