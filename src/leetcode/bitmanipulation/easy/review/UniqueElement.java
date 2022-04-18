package leetcode.bitmanipulation.easy.review;

public class UniqueElement {
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,2,1};
        System.out.println(singleNumber(arr));
    }
}
