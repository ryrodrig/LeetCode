package leetcode.bitmanipulation.easy.review;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans =0;
        for(int i=0; i<32;i++) {
            int temp = n & (1<<i);
            if(temp != 0) {
                // add 1 only if temp is not 1
                ans = ans | (1<<31-i);
            }
        }
        return ans;
    }
}
