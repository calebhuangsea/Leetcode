package M912SortAnArray;

/**
 * Sort an array in O(nlog(n)) time
 * Approach one: merge sort
 * Approach two: quick sort
 */
public class Solution {

    /**
     * Merge sort (36ms 54.16%, 53.6MB 26.19%)
     * Time complexity: O(nlog(n)), split into two sub-array each time and merge
     * Space complexity: O(1), we use no extra array, only keep track index
     */
//    public int[] sortArray(int[] nums) {
//        divide(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    // merge two subarray by sorting them using brute force
//    public void merge(int[] arr, int lo, int mid, int hi) {
//        int[] res = new int[hi - lo + 1];
//        int i = lo;
//        int j = mid + 1;
//        int k = 0;
//        while (i <= mid && j <= hi) {
//            if (arr[i] < arr[j]) {
//                res[k++] = arr[i++];
//            } else {
//                res[k++] = arr[j++];
//            }
//        }
//        while (i <= mid) {
//            res[k++] = arr[i++];
//        }
//        while (j <= hi) {
//            res[k++] = arr[j++];
//        }
//        for (int z = 0; z < res.length; z++) {
//            arr[z + lo] = res[z];
//        }
//    }
//
//    // divide the array into two half recursively and merge after that
//    public void divide(int[] arr, int lo, int hi) {
//        if (lo < hi) {
//            int mid = lo + ((hi - lo) >> 1);
//            divide(arr, lo, mid);
//            divide(arr, mid + 1, hi);
//            merge(arr, lo, mid, hi);
//        }
//    }
    /**
     * Quick sort (2060ms 5%, 56.4MB 5.96%)
     * Time complexity: O(nlog(n)), pick a pivot and move element to the left and right
     * Space complexity: O(1), we use no extra array, only keep track index
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    // find the pivot and recursively do the quick sort
    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);
    }

    // find a pivot and put an element that is larger than it and closest to the left to the left
    // put an element that is smaller than it and closest to the right to the right
    // put the pivot in the middle
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
