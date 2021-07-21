package playcode.linkedlist;

import org.junit.jupiter.api.Test;
import playcode.common.ListNode;

public class ReverseLinkedList {
    /**
     * Three methods:
     * V1 and V2,  only reverse the next pointer
     *
     * V3 recursive, truly inplace
     */

    public ListNode reverseListV1(ListNode head) {
        ListNode preNode =null;
        ListNode currNode = head;
        while(currNode !=null){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    ListNode reverse(ListNode curr, ListNode pre){
        if(curr ==null){
            return pre;
        }
        ListNode next = curr.next;
        curr.next = pre;
        return reverse(next, curr);
    }






    private ListNode node;
    private boolean finished = false;

    public ListNode reverseListV3(ListNode head) {
        if (head == null) {
            return head;
        }
        node = head;
        helper(head.next);
        return head;
    }

    private void helper(ListNode n2) {
        if (n2 == null) {
            return;
        }

        helper(n2.next);
        if (node == n2 || n2.next == node) {
            finished = true;
        }
        if(!finished) {
            int tmp = n2.val;
            n2.val = node.val;
            node.val = tmp;
            node = node.next;
        }
    }

    @Test
    void t() {
        ListNode head = ListNode.getListNode();
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.reverseListV3(head);


    }

}
