package leetcode.dynamicProgramming.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    // As the requirement is to only return the count , we will need to use dynamic programming.
    // if the requirement was to get all the possible result set then we had to choose backtracking.
    public int climbStairs(int n) {
        return findResult(n, new HashMap<Integer,Integer>());
    }


    private int findResult(int n , Map<Integer,Integer> dp) {
        if(n == 0) {
            return 1;
        } else if(n<0) {
            // situation where the path leads us to underground.
            return 0;
        }

        // memoization
        if(dp.containsKey(n)) {
            return dp.get(n);
        }

        dp.put(n,findResult(n-1,dp) + findResult(n-2,dp));
        return dp.get(n);
    }
}
