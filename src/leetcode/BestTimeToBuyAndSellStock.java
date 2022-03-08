package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock {

    // My approach.
    // Simpler approach.
//    private int calculateProfit(int[] prices,int index,Map<Integer,Integer> cache) {
//        if(cache.containsKey(prices[index])) {
//            return cache.get(prices[index]);
//        }
//        if(prices.length <= 1) {
//            return 0;
//        }
//        if(prices.length <= 2) {
//            int interminMax = prices[1] - prices[0];
//            return interminMax < 0 ? 0 : interminMax;
//        }
//
//
//        int maxFutureProfitForToday = 0;
//        for(int i= (index + 1); i < prices.length ; i++) {
//            maxFutureProfitForToday = Integer.max((prices[i] - prices[index]) , maxFutureProfitForToday);
//
//        }
//        cache.put(prices[index], maxFutureProfitForToday);
//        return maxFutureProfitForToday;
//    }
//
//    public int maxProfit(int[] prices) {
//
//        int maxProfit = 0;
//        Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
//        for(int i=0; i < prices.length; i ++) {
//            maxProfit = Integer.max(maxProfit , calculateProfit(prices , i , cache));
//        }
//
//        return maxProfit;
//
//    }


    public int maxProfit(int[] prices) {

       // idea is to identify the largest difference.

        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;
        for(int i=0; i< prices.length; i++) {
            if(prices[i] < min_val) {
                min_val = prices[i];
            } else if(prices[i] - min_val > max_profit) {
                max_profit = prices[i] - min_val;
            }


        }
        return max_profit;
    }

    public static void main(String[] args) {
        //
    }

}
