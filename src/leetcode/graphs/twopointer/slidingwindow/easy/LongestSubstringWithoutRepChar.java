package leetcode.graphs.twopointer.slidingwindow.easy;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepChar {

    // O(n)
    // use 2 pointers "start" and "end" and a HashSet to store unique characters..
    // increment end if character not in set
    // increment "start" if character in set and remove character at "Start" from HashSet./
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> uniqueSet = new HashSet<>();
        int start = 0;
        int end = 0;
        int longestStrCnt = 0;
        char[] characterArray = s.toCharArray();
        while(end < characterArray.length) {
            if(uniqueSet.contains(characterArray[end])) {
                uniqueSet.remove(characterArray[start]);
                start++;
            } else {
                uniqueSet.add(characterArray[end]);
                end++;
            }
            if(end-start > longestStrCnt) {
                longestStrCnt = end-start;
            }
        }
        return longestStrCnt;
    }
}
