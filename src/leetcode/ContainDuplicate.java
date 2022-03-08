package leetcode;

import java.util.HashSet;
import java.util.Set;

// O(n)
public class ContainDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> container = new HashSet<>();

        for(int num : nums) {
            if(container.contains(num)) {
                return true;
            }
            container.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate containDuplicate = new ContainDuplicate();
        int nums[] = {1,2,3,1};
        containDuplicate.containsDuplicate(nums);
    }
}
