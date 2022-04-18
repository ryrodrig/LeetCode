package leetcode.graphs.twopointer.easy;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {

        int zeroBeginPtr = 0;
        int ctr = 0;

        while(ctr < nums.length){
            if(nums[ctr] != 0) {
                int temp = nums[zeroBeginPtr];
                nums[zeroBeginPtr] = nums[ctr];
                nums[ctr] = temp;
                zeroBeginPtr++;
            }
            ctr++;
        }

    }

}
