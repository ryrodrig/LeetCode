package leetcode.bitmanipulation.easy.review;

public class ParityOfNumber {

    public static boolean findParity(int n)
    {
        int ctr=0;
        while(n != 0) {
            // unsets right most bit.
            n = n & (n-1);
            ctr ++;
        }
        System.out.println(ctr);
        // odd even check
        return (ctr & 1) == 0;
    }

    public static void main(String[] args) {
        findParity(127);
    }
}
