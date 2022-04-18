package leetcode.linkedlist;

/**
 * Recursive and non recursive version of reversing a linked list.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        int[] nodeVal = {1, 2, 3, 4, 5};
        ListNode head = null;
        ListNode currentNode;
        ListNode prevNode = null;
        for (int i = 0; i < nodeVal.length; i++) {
            currentNode = new ListNode(nodeVal[i]);

            if (head == null) {
                head = currentNode;
            }
            if (prevNode != null) {
                prevNode.next = currentNode;
            }
            prevNode = currentNode;
        }
        ListNode reversedHead = reverseList(head);
        while(reversedHead != null) {
            System.out.print(reversedHead.val + "--> " );
            reversedHead = reversedHead.next;
        }
    }

    // Recursive option.
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            ListNode tail = head;
            return tail;
        }

        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }




    /*
    Non recursive version
    */

//      public ListNode reverseList(ListNode head) {

//          ListNode prev= null;
//          ListNode nextNode = null;

//          while(head != null) {
//              nextNode = head.next;
//              head.next = prev;
//              prev = head;
//              head=nextNode;
//          }

//         return prev;
//     }

}
