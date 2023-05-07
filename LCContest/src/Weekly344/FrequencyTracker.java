package Weekly344;

public class FrequencyTracker {
    int[] freqCount = new int[100001];
    int[] numCount = new int[100001];

    public FrequencyTracker() {
        freqCount[0] = 100000;
    }

    public void add(int number) {
        int old = numCount[number];
        freqCount[old]--;
        freqCount[old + 1]++;
        numCount[number]++;
    }

    public void deleteOne(int number) {
        // check freq of this
        int old = numCount[number];
        if (old == 0) {
            return;
        }
        freqCount[old]--;
        freqCount[old - 1]++;
        numCount[number]--;
    }

    public boolean hasFrequency(int frequency) {
        return freqCount[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
