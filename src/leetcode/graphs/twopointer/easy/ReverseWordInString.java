package leetcode.graphs.twopointer.easy;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordInString {
    public String reverseWords(String s) {

        int startPtr = 0;
        int currentPtr = 0;
        char[] c = s.toCharArray();
        while(currentPtr < c.length) {
            if(c[currentPtr] == ' ') {
                // swap elements of the word
                swap(c,startPtr,currentPtr-1);
                startPtr = currentPtr + 1;
            }
            currentPtr ++;
        }
        swap(c,startPtr,currentPtr-1);
        return String.valueOf(c);
    }

    private void swap(char[] c , int startPtr , int endPtr) {
        while(startPtr < endPtr) {
            char temp = c[startPtr];
            c[startPtr] = c[endPtr];
            c[endPtr] = temp;
            startPtr ++;
            endPtr--;
        }
    }
}
