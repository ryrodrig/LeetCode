package leetcode.dynamicProgramming.medium.review;

public class HouseRobber {

    class Solution {

        // My Solution
        // public int rob(int[] nums) {
        //     if(nums.length < 2) {
        //         return nums[0];
        //     }
        //    int firstHousePath = findResult(nums,0,new HashMap<>()) ;
        //     int secondHousePath = findResult(nums,1,new HashMap<>()) ;
        //     return firstHousePath > secondHousePath ? firstHousePath : secondHousePath;
        // }

//     private int findResult(int[] nums, int startNode, Map<Integer,Integer> dp) {
//         if(dp.containsKey(startNode)) {
//             return dp.get(startNode);
//         }
//         if(startNode >= nums.length - 2) {
//             dp.put(startNode,nums[startNode]);
//             return nums[startNode];
//         }
//         for(int i = startNode+2;i<nums.length;i++) {
//             int moneyRobbed = nums[startNode] + findResult(nums,i,dp);
//             if(dp.containsKey(startNode)) {
//                 dp.put(startNode, moneyRobbed > dp.get(startNode) ? moneyRobbed : dp.get(startNode));
//             }  else {
//                 dp.put(startNode,moneyRobbed);
//             }
//         }

//         return dp.get(startNode).intValue();

//     }


        // recursive solution -
        // Robber can choose to select current house or the loot from previous house
        // if he chooses current house - he adds the loot from this house + loots from i-2 houses
        // if he does not choose current hose - he chooses loot from previous house
        // requirement is to make more money - so he will need to decide if he chooses maximum loot from the current house + i-2 or ignore this house and chose maximum loot from previous (i-1) house -c onsidering the above closues are met when i-1 chose was processed.


        public int rob(int[] nums) {
            int[] memo = new int[nums.length+1];
            for(int i=0;i<memo.length;i++) {
                memo[i]=-1;
            }
            return findResult(nums,nums.length-1,memo);
        }

        private int findResult(int[] nums, int currentHouse, int[] maxLoot) {

            if(currentHouse < 0) {
                return 0;
            }
            if(maxLoot[currentHouse] != -1) {
                return maxLoot[currentHouse];
            }

            maxLoot[currentHouse] = Math.max(nums[currentHouse] + findResult(nums,currentHouse-2,maxLoot), findResult(nums,currentHouse-1,maxLoot));
            return maxLoot[currentHouse];
        }

        // Iterative versiion
        // http://www.crazyforcode.com/house-robber-dynamic-programming/
//        public class CrazyForCode {
//            public int steal(int[] num) {
//                if(num==null || num.length==0){
//                    return 0;
//                }
//                int[] dp= new int[num.length+1];
//                dp[0]=0;
//                dp[1]=num[0];
//                for(int i=2; i<=num.length;i++){
//                    dp[i] =Math.max(dp[i-1],num[i-1]+dp[i-2]);
//                }
//                return dp[num.length];
//            }
//        }

    }
}
