package leetcode.dynamicProgramming.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */
public class Triangle {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            return findResult(triangle,0,0,new HashMap<String,Integer>());
        }

        private int findResult(List<List<Integer>> triangle, int row, int col, Map<String, Integer> dp) {
            String cacheKey = String.valueOf(row) + "," + String.valueOf(col);
            Integer currentVal = triangle.get(row).get(col);
            if(dp.containsKey(cacheKey)) {
                return dp.get(cacheKey);
            }
            if(row == triangle.size()-1) {
                return currentVal;
            }
            Integer computedCost = currentVal + Integer.valueOf(Math.min(findResult(triangle,row+1,col,dp),findResult(triangle,row+1,col+1,dp)));
            dp.put(cacheKey,computedCost);
            return dp.get(cacheKey);
        }
    }
}
