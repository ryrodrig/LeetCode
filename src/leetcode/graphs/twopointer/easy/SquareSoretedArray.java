package leetcode.graphs.twopointer.easy;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquareSoretedArray {

    // public static class Stack {
//         int val;
//         int top = -1;
//         int[] container;

//         public Stack (int size) {
//             container = new int[size];
//         }

//         public void push(int val) {
//             if(top >= container.length) {
//                 throw new RuntimeException("Stack full");
//             }

//             container[++top] = val;
//         }

//         public int pop() {
//             if(top == -1) {
//                 throw new RuntimeException("Stack Empty");
//             }

//             return container[top--];
//         }

//         public int top() {
//             if(top == -1) {
//                 throw new RuntimeException("Stack Empty");
//             }

//             return container[top];
//         }

//         public boolean isEmpty() {
//             return top == -1;
//         }

//     }

//     public int[] sortedSquares(int[] nums) {

//         Stack stk = new Stack(nums.length);
//         int[] result = new int[nums.length];
//         int resultPtr = 0;
//         for(int i=0;i<nums.length;i++) {
//             int squaredNum = nums[i] * nums[i];
//             if(stk.isEmpty()) {
//                 stk.push(squaredNum);
//             } else {
//                 while((!stk.isEmpty()) && stk.top() < squaredNum) {
//                     result[resultPtr] = stk.pop();
//                     resultPtr++;
//                 }
//                     stk.push(squaredNum);
//             }
//         }

//         while(!stk.isEmpty()) {
//             result[resultPtr] = stk.pop();
//             resultPtr++;
//         }

//         return result;
//     }


    // O(n) solution.
    public int[] sortedSquares(int[] nums) {

        int start = 0;
        int end = (nums.length-1);
        int result[] = new int[nums.length];
        for(int i=(nums.length-1);i>=0;i--) {
            int squaredStart = nums[start] * nums[start];
            int squaredEnd = nums[end] * nums[end];
            if(squaredStart > squaredEnd) {
                result[i] = squaredStart;
                start++;
            } else {
                result[i] = squaredEnd;
                end--;
            }
        }

        return result;
    }
}
