package Weekly341;

public class Q3 {
    /**
     * [Easy to understand] Java One Pass Solution
     * We can keep track of previous character and see if we want to insert or not
     * O(N)
     * O(1)
     */
    public int addMinimum(String word) {
        int i = 0;
        char prev = 'c'; // initialize left should be 'a', so prev = 'c'
        int count = 0;
        while (i < word.length()) {
            // if satisfy then move forward and update prev
            // otherwise don't move i because we 'insert' a character by adding count
            if (prev == 'c') {
                if (word.charAt(i) != 'a') {
                    count++;
                    i--;
                }
                prev = 'a';
            } else if (prev == 'b') {
                if (word.charAt(i) != 'c') {
                    count++;
                    i--;
                }
                prev = 'c';
            } else if (prev == 'a') {
                if (word.charAt(i) != 'b') {
                    count++;
                    i--;
                }
                prev = 'b';
            }
            i++;
        }
        // handle the tail situation
        if (prev == 'a') {
            count += 2;
        } else if (prev == 'b') {
            count += 1;
        }
        return count;
    }
}
