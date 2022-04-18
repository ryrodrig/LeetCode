package leetcode.graphs.twopointer.easy;

import leetcode.graphs.twopointer.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while(fastPointer != null) {
            slowPointer = slowPointer.next;
            if(fastPointer.next != null && fastPointer.next.next !=null) {
                fastPointer = fastPointer.next.next;
            } else {
                return slowPointer;
            }
        }
        return slowPointer;
    }
}
