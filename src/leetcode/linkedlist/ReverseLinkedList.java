package leetcode.linkedlist;

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

    private static ListNode reverse(ListNode currentNode) {
        if (currentNode.next == null) {
            return currentNode;
        }


        ListNode updatedHead = reverse(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        System.out.println("Head value" + updatedHead.val);
        return updatedHead;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head);
    }

}
