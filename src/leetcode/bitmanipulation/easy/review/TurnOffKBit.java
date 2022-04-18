package leetcode.bitmanipulation.easy.review;

/**

Given an integer n and a positive number k, turn off k'th bit in n.

Input: n = 20, k = 3
Output: 16
Explanation:

20 in binary is 00010100
16 in binary is 00010000

Input: n = -20, k = 3
Output: -24
Explanation:

-20 in binary is 1111111111101100
-24 in binary is 1111111111101000

*/
public class TurnOffKBit {

    // TurnONKbit - n | (1<< k-1)
    // toggle K bit = n^ (1<<k-1)
    public static int turnOffKthBit(int n, int k)
    {
        // Write your code here...
        int power = (1 << (k-1));
        System.out.println(power);
        int inverse = ~power;
        System.out.println(inverse);
        return (n & inverse);
    }


    public static void main(String[] args) {
        System.out.println(turnOffKthBit(20,3));
    }

}
