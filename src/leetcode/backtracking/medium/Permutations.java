package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    // case of backtracking algorithm
// algorithm needs -
// 1. Path - array containing the item selected
// 2. SelectionList - available list of items that can be selected.
// 3. end condition - in our case when path contains K elements
    public void backtrack(List<Integer> path , List<Integer> selectionList, List<List<Integer>> result, int arrLen) {
        // end condition - get all permutation of the num passed
        if(arrLen==path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i<selectionList.size();i++) {
            // if element already in path, ignore
            if(path.contains(selectionList.get(i))) {
                continue;
            }
            // select path
            path.add(selectionList.get(i));
            // backtrack
            backtrack(path,selectionList,result,arrLen);
            // deselect
            path.remove(path.size()-1);
        }

    }



    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> selectionList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(new ArrayList<>(),selectionList,result,nums.length);
        return result;

    }
}
