package leetcode.graphs.twopointer.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

    // Swap entries using 2 pointers.
    public void reverseString(char[] s) {

        int startPtr = 0;
        int endPtr = s.length - 1;
        while(startPtr < endPtr) {
            char temp = s[startPtr];
            s[startPtr] = s[endPtr];
            s[endPtr] = temp;
            startPtr ++;
            endPtr --;
        }

    }
}
