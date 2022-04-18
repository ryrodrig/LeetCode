package leetcode.graphs.twopointer.medium.review;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
// IMPORTANT : USES REVERSAL ALGORITHM - check eReader notes for details.
public class RotateArray {

    // reversal algorithm
    public void rotate(int[] nums, int k) {
        // if K is more than nums.length modulus would reduce the number of times we loop through the list
        // eg : if K = 6 and array size = 5 , 6 iterations == 1 iteration.
        k = k % nums.length;
        // Reverse the whole array
        reverse(nums,0,nums.length -1);
        // reverse first K-1 elements
        reverse(nums,0,k-1);
        // reverse remaining elements.
        reverse(nums,k,nums.length -1);
    }

    private void reverse(int[] nums, int start,int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
