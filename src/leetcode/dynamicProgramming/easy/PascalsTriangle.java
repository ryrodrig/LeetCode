package leetcode.dynamicProgramming.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class PascalsTriangle {

    private List<Integer> recursivePascalTriangle(int val, List<List<Integer>> finalList) {
        List<Integer> currentResult = new ArrayList<Integer>();
        if(val == 1) {
            currentResult.add(1);
            finalList.add(currentResult);
            return currentResult;
        }

        List<Integer> prevResult = recursivePascalTriangle((val-1), finalList);
        currentResult.add(1);
        for(int i=1; i<val-1; i++) {
            int value = prevResult.get(i-1) + prevResult.get(i);
            currentResult.add(value);
        }
        currentResult.add(1);
        finalList.add(currentResult);
        return currentResult;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        recursivePascalTriangle(numRows, finalList);
        return finalList;
    }
}
