package leetcode;

/*
      Kadene's algorithm
      [-2,1,-3,4,-1,2,1,-5,4]
      [-2]
      [-2,1] -2+1 = -1 < 1 so 1
      [-2,1,-2] -3+1(prev element) = -2 > -3 (current element) so -3
      [-2,1,-2, 4] -2 + 4 = 2 < 4 so 4
      [-2,1,-2,4,3] 4-1 = 3 > -1
      [-2,1,-2,4,3,5] 2+3 = 5 > 2
      [-2,1,-2,4,3,5,6] 5+ 1 = 6 > 1
      [-2,1,-2,4,3,5,6,1] 6-5 = 1 > -5
      [-2,1,-2,4,3,5,6,1,5] 1+4 = 5 > 4

      find highest sum from second array
      time complexity o(n) - iterate once through the array
      space complexity o(n) - an additional array to hold the result
    */
public class MaximumSumSubarrayKadeneAlgo {

    public static int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int finalMax = nums[0];
        for(int i=1 ; i < nums.length; i++) {
            currentMax = Integer.max(currentMax + nums[i], nums[i]);
            finalMax = Integer.max(currentMax,finalMax);
        }

        return finalMax;
    }

    public static void main(String[] args) {
        int nums[] = {5,4,-1,7,8};
        int maxSum = maxSubArray(nums);
        System.out.println("Max Sum : "  + maxSum);
    }
}
