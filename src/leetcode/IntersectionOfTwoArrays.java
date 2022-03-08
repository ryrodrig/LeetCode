package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class IntersectionOfTwoArrays {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> container = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int resPtr = 0;
        for(int num: nums1) {
            if(container.containsKey(num)) {
                int count = container.get(num);
                count++;
                container.put(num,count);
            } else {
                container.put(num,1);
            }

        }

        for(int num: nums2) {
            if(container.containsKey(num)) {
                result.add(num);
                int count = container.get(num);
                count--;
                container.put(num,count);
                if(count == 0) {
                    container.remove(num);
                }
            }
        }

        int[] resultArr = new int[result.size()];
        for(int i=0; i< result.size(); i++ ) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    public static void main(String[] args) {

        int[] num1 =  { 54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47
                ,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41 };
int[] num2 =
        {17, 17, 87, 98, 18, 53, 2, 69, 74, 73, 20, 85, 59, 89, 84, 91, 84, 34, 44, 48, 20, 42, 68, 84, 8, 54, 66, 62,
                69, 52, 67, 27, 87, 49, 92, 14,
                92, 53, 22, 90, 60, 14, 8, 71, 0, 61, 94, 1, 22, 84, 10, 55, 55, 60, 98, 76, 27, 35, 84, 28, 4, 2, 9,
                44, 86, 12, 17, 89, 35, 68, 17, 41 };

                Arrays.stream(intersect(num1, num2)).forEach(System.out::println);

    }

}
