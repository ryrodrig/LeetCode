package leetcode;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2,
sorted in non-decreasing order, and two integers m and n,
 representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function,
 but instead be stored inside the array nums1. To accommodate this,
  nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {


    // Brute Force approach.
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        int[] tempArray = new int[nums1.length];
//        int nums1Ctr = 0;
//        int nums2Ctr = 0;
//        int ctr = 0;
//        while(nums1Ctr < m && nums2Ctr < n)  {
//            if(nums1[nums1Ctr] < nums2[nums2Ctr]) {
//                tempArray[ctr] = nums1[nums1Ctr];
//                nums1Ctr++;
//            } else {
//                tempArray[ctr] = nums2[nums2Ctr];
//                nums2Ctr++;
//            }
//            ctr++;
//        }
//        while(nums1Ctr < m) {
//            tempArray[ctr] = nums1[nums1Ctr];
//            nums1Ctr++;
//            ctr++;
//        }
//        while(nums2Ctr < n) {
//            tempArray[ctr] = nums2[nums2Ctr];
//            nums2Ctr++;
//            ctr++;
//        }
//        for(int i=0 ; i < nums1.length; i++) {
//            nums1[i] = tempArray[i];
//        }
//    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int ctr = nums1.length - 1;
        int nPtr1 = m - 1;
        int nPtr2 = n-1;
        while(ctr >= 0) {
            if(nPtr1 < 0) {
                nums1[ctr] = nums2[nPtr2];
                nPtr2--;
                ctr--;
                continue;
            }
            if(nPtr2 < 0) {
                nums1[ctr] = nums1[nPtr1];
                nPtr1--;
                ctr--;
                continue;
            }

            if(nums1[nPtr1] > nums2[nPtr2]) {
                nums1[ctr] = nums1[nPtr1];
                nPtr1--;
            } else {
                nums1[ctr] = nums2[nPtr2];
                nPtr2--;
            }
            ctr--;
        }
    }

    public static void main(String[] args) {
//        [1,2,3,0,0,0]
//3
//[2,5,6]
//3
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(System.out::println);
    }

}
