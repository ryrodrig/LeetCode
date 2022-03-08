package leetcode;

import java.awt.*;

public class AddTwoNumbersLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootPtr = null;
        ListNode currentNode = null;
        int carry = 0;
        while(l1 !=null || l2!= null || carry != 0) {
            ListNode sum = new ListNode(0);
            if(currentNode == null) {
                rootPtr = sum;
                currentNode = sum;
            } else {
                currentNode.next = sum;
                currentNode = sum;
            }
            int firstInt = 0;
            int secondInt = 0;
            if(l1 != null ) {
                firstInt = l1.val;
                l1 = l1.next;
            }
            if(l2 != null ) {
                secondInt = l2.val;
                l2 = l2.next;
            }
            int intSum = firstInt + secondInt + carry;
            if(intSum > 9) {
                sum.val = intSum - 10;
                carry = 1;
            } else {
                sum.val = intSum;
                carry = 0;
            }
        }
        return rootPtr;
    }

    public static void main(String[] args) {

    }


}
