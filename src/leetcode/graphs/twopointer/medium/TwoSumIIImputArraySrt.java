package leetcode.graphs.twopointer.medium;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSumIIImputArraySrt {
// 2 pointers - one start and other end
    // decrement enpPtr if difference (target -start) is < endPtrVal
    // Else increment startPtr
    public int[] twoSum(int[] numbers, int target) {

        int startPtr = 0;
        int endPtr = (numbers.length - 1);
        int[] result = new int[2];
        while(startPtr < endPtr) {
            int startPtrVal = numbers[startPtr];
            int endPtrVal = numbers[endPtr];
            int difference =target - startPtrVal;
            if(difference == endPtrVal) {
                result[0] = startPtr + 1;
                result[1] = endPtr + 1;
            }
            if(difference < endPtrVal) {
                endPtr --;
            } else {
                startPtr ++;
            }
        }

        return result;
    }
}
