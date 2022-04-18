package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class combinations {

    // case of backtracking algorithm
// algorithm needs -
// 1. Path - array containing the item selected
// 2. SelectionList - available list of items that can be selected.
// 3. end condition - in our case when path contains K elements
    class Solution {


        public void backtrack(List<Integer> path, List<Integer> selectionList,List<List<Integer>> result,int k) {
            System.out.println("Selection List:::  " + selectionList);
            System.out.println("Path:::  " + path);
            List<Integer> currentSelList = new ArrayList<>();
            // exit condition
            if(path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            currentSelList.addAll(selectionList);
            // Iterate through selection list
            while(!currentSelList.isEmpty()) {

                // Core algorithm
                // select item
                int removedEle = currentSelList.remove(currentSelList.size()-1);
                path.add(removedEle);
                // backtrack
                System.out.println("Iterate -> Selection List:::  " + currentSelList);
                backtrack(path,currentSelList,result,k);
                // deselect
                path.remove(path.size()-1);

            }


        }


        public List<List<Integer>> combine(int n, int k) {
            List<Integer> selectionList = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            IntStream.rangeClosed(1, n).forEach(i -> selectionList.add(i));
            backtrack(new ArrayList<>(),selectionList,result,k);
            return result;
        }
    }
}
