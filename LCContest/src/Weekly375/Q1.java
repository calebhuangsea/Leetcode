package Weekly375;
import java.util.*;
public class Q1 {

    public int countTestedDevices(int[] b) {
        int pre = 0;
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] - pre > 0) {
                pre++;
                count++;
            }
        }
        return count;
    }
}
