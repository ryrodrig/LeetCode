package leetcode.bitmanipulation.easy.review;

/**

Given an integer, find position of the rightmost set bit in it.

Input: n = 20
Output: 3
Explanation: 20 in binary is 00010100

*/
public class PositionOfRIghtMostSetBit {

    public static int positionOfRightmostSetBit(int n)
    {
        // Write your code here...
        int ctr = 1;
        while(n != 0) {
            if((n&1) == 0) {
                ctr++;
                n = n >>> 1;
            } else {
                return ctr;
            }
        }

        return 0;
    }

}
