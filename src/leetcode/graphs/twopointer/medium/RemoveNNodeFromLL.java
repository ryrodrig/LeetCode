package leetcode.graphs.twopointer.medium;

import leetcode.graphs.twopointer.ListNode;

/**
 * Share
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNNodeFromLL {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode currentPtr = head;
        ListNode prevPtr = null;
        int trigger = 0;
        while(currentPtr.next != null) {
            currentPtr = currentPtr.next;
            prevPtr = prevPtr !=null ? prevPtr.next : null;
            // Start previous ptr once current pointer has passed "n" number of nodes
            trigger ++;
            if(trigger==n) {
                prevPtr = head;
            }

        }

        if(prevPtr !=null) {
            prevPtr.next = prevPtr.next.next;
        } else {
            head=head.next;
        }

        return head;

    }
}
