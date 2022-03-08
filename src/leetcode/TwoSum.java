package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> remainderMap = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i ++) {
            if (remainderMap.containsKey(nums[i])) {

                result[0] = remainderMap.get(nums[i]);
                result[1] = i;
                return result;
            }
            remainderMap.put((target - nums[i]) , i);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        Arrays.stream(twoSum(nums , 9)).forEach(System.out::println);
    }
}
