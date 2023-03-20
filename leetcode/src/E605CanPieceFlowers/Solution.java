package E605CanPieceFlowers;

class Solution {

    /**
     * Greedy Algorithm, pick the closest available slot
     * Time Complexity: O(N) 1ms 100%
     * Space Complexity: O(1) 44MB 29.2%
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i >= 1 && flowerbed[i - 1] == 0 || i == 0) && (i == flowerbed.length - 1 || i < flowerbed.length - 1 && flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    sum++;
                }
            }
        }
        return sum >= n;
    }
}
