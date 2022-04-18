package leetcode.bitmanipulation.easy.review;

public class UniqueElementFor3 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        // loop through every single bit
        for(int i=0;i<32;i++) {
            int sum =0;
            // loop through every single nums
            for(int j=0;j<nums.length;j++) {
                // bit at ith position for nums[j];
                int bit=(nums[j]>>i)&1;
                sum += bit;
            }
            // if there are 3 repeating characters the mod of the bits of those 3 numbers will be 0
            // the remainder is the value of the number that is unique.
            int mod = sum % 3;
            ans = ans |(mod<<i);
        }
        return ans;
    }
}

