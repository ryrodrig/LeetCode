package leetcode.bitmanipulation.medium.review;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 */
public class DivideTwoIntegers {

    /**
     * Division can be represented as
     *
     * Dividend = (quotient) * divisor + remainder.
     *
     * In Bit manipulation
     *
     * Dividend = (divisor * 2^x) + divisor + 2^j).. + remainder
     *
     * Eg - 58 = (11) * 5 + 3
     *      58 = ( 2^3 + 2^1 + 2^0) * 5 + 3
     *      8 = ( 2^3 * 5 ) + (2^1 * 5) + (2^0 * 5) + 3
     *
     *
     * https://leetcode.com/problems/divide-two-integers/discuss/1516367/Complete-Thinking-Process-or-Intuitive-Explanation-or-All-rules-followed-or-C%2B%2B-code
     */

    public int divide(int dividendInput, int divisorInput) {
        List<Integer> quotientList = new ArrayList<>();
        // loop until dividend is greater than divisor.
        boolean isPositive = false;
        if((dividendInput < 0 && divisorInput < 0) ||  (dividendInput > 0 && divisorInput > 0))  {
            isPositive = true;
        }

//         Integer dividend = dividendInput < 0 ? ~dividendInput+1 : dividendInput;
//         Integer divisor = divisorInput < 0 ? ~divisorInput+1 : divisorInput;
        long dividend = Math.abs((long) dividendInput);
        long divisor = Math.abs((long) divisorInput);
        if(divisor == 1) {
            return isPositive ? (int)dividend : (int)-dividend;
        }
        while(dividend >= divisor) {
            int powerTwo = 0;
            // 2!
            while(((1 << powerTwo)  * divisor) <= dividend) {
                powerTwo++;
            }
            quotientList.add(1 << (powerTwo-1));
            dividend -= ((1<<(powerTwo-1)) * divisor);
        }
        int result =  quotientList.stream().reduce(0,(subtotal,element) -> {
            return subtotal + element;
        });
        return isPositive ? result : -result;

    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648,-1));
    }

}
