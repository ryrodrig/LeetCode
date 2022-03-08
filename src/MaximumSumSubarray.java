/*Given an integer array, find the maximum sum among all subarrays possible.

        The problem differs from the problem of finding the maximum subsequence sum. Unlike subsequences, subarrays are required to occupy consecutive positions within the original array.


        For example,

        Input:  nums[] = [2, -4, 1, 9, -6, 7, -3]

        Output: The maximum sum of the subarray is 11 (Marked in Green)*/
public class MaximumSumSubarray {

    // Recursive version , divide and conquer
    public static int findMaximumSumSubArray(int[] nums, int left, int right) {

        System.out.println("Nums: " + nums + " left: " + left + " right: " +right);
        if(left == right) {
            System.out.println("Left == Right. Value : " + nums[left]);
            return nums[left];
        }

        // find middle
        int mid = (right + left) / 2;

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i= mid; i>= left; i--) {
            sum += nums[i];
            if(sum > leftMax) {
                leftMax = sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid + 1; i<= right; i++) {
            sum += nums[i];
            if(sum > rightMax) {
                rightMax = sum;
            }
        }
        System.out.println("Left Max: " + leftMax + " rightMax: " + rightMax);

        int maxRightLeft = Integer.max(findMaximumSumSubArray(nums, left, mid), findMaximumSumSubArray(nums, mid+1,
                                                                                                       right));

        System.out.println(" MaxRightLeft : " + maxRightLeft);

        int maximumSum =  Integer.max(maxRightLeft, leftMax + rightMax);

        System.out.println(" left: " + left + " right: " +right);
        System.out.println(" Maximum Sum per iteration : " + maximumSum);

        return maximumSum;
    }

    public static void main(String[] args) {
        int nums[] = {2,-4,1,9,-6,7,-3};
        int maxSum = findMaximumSumSubArray(nums, 0, nums.length -1);
        System.out.println("Max Sum : "  + maxSum);
    }
}
