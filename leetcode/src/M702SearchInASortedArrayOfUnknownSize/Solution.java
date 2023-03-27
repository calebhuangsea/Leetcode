package M702SearchInASortedArrayOfUnknownSize;

public class Solution {
    /**
     * Binary search, enlarge the boundary until then do the search
     * Time Complexity O(log(N)) 2ms 100%
     * Space Complexity O(1) 43.2MB 67.98%
     */
//    public int search(ArrayReader reader, int target) {
//        int lo = 0;
//        int hi = 1;
//        while (reader.get(hi) < target) {
//            lo = hi;
//            hi *= 2;
//        }
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int num = reader.get(mid);
//            if (num == target) {
//                return mid;
//            } else if (num < target) {
//                lo = mid + 1;
//            } else {
//                hi = mid - 1;
//            }
//        }
//        return -1;
//    }
}
