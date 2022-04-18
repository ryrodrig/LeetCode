package leetcode.graphs.twopointer.slidingwindow.medium.review;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for(int i=0;i<s1.length();i++) {
            // set character from S1 within counter array to 1;
            count[s1.charAt(i) - 'a']++;
            // decrement the counter array at char location by 1.
            count[s2.charAt(i) - 'a']--;
        }
        // if all Zero then the permutation is used.
        if(isAllZero(count)) {
            return true;
        }

        int start = 0;
        int end = s1.length();

        // iterate through in windows, decrementing the count array when an element enters the window and incrementing once out of the window.. Make sure to check is the count array is all zeros for each iteration.
        while(end < s2.length()) {
            count[s2.charAt(start) - 'a']++;
            start++;
            count[s2.charAt(end) - 'a']--;
            end++;

            if(isAllZero(count)) {
                return true;
            }
        }

        return false;
    }

    private boolean isAllZero(int[] c) {
        for(int i=0;i<26;i++) {
            if(c[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
