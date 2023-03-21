package Q1PatternSourceMatching;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given two strings - pattern and source. The first string pattern contains only the symbols 0 and 1, and the second string source contains only lowercase English letters.
 *
 * Let's say that pattern matches a substring source[l..r] of source if the following three conditions are met:
 *
 * they have equal length,
 * for each 0 in pattern the corresponding letter in the substring is a vowel,
 * for each 1 in pattern the corresponding letter is a consonant.
 * Your task is to calculate the number of substrings of source that match pattern.
 *
 * Note: In this task we define the vowels as 'a', 'e', 'i', 'o', 'u', and 'y'. All other letters are consonants.
 */
public class Solution {
    int solution(String pattern, String source) {
        Set<Character> vowel = new HashSet<>();
        char[] pattern1 = pattern.toCharArray();
        char[] source1 = source.toCharArray();
        int count = 0;
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('y');
        for (int i = 0; i < source.length() - pattern.length() + 1; i++) {
            int flag = 1;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern1[j] == '0' && !vowel.contains(source1[j + i])) {
                    flag = 0;
                    break;
                } else if (pattern1[j] == '1' && vowel.contains(source1[j + i])) {
                    flag = 0;
                    break;
                }
            }
            System.out.println(flag + " : " + i);
            count += flag;
        }
        return count;
    }

}
