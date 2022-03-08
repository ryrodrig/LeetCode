package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> counterSet = new HashSet<>();
        int counter = 0;
        int longestSubstringCtr = 0;
        for(char c : s.toCharArray()) {
            if(counterSet.contains(c)) {
                if(counter > longestSubstringCtr) {
                    longestSubstringCtr = counter;
                }
                counter = 1;
                counterSet.clear();
            } else {
                counterSet.add(c);
                counter ++;
            }
        }
        if(counter > longestSubstringCtr) {
            longestSubstringCtr = counter;
        }
        return longestSubstringCtr;
    }
}
