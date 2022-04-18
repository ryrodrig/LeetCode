package leetcode.bitmanipulation.easy.review;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */
public class PowerOfTwo {

    // if n is a power of 2 it will have just one '1'
    // 001 , 010 , 100
    // n-1 will not have one at the location that n had 1
    // so n & n-1 will always be zero
    // if not is not a power of 2 then there will be more than one '1's
    // eg : 6 - 110 , 5 - 101 n & (n-1) = 110 - 101 = 100 (4) which is greater than 0.

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }
}
