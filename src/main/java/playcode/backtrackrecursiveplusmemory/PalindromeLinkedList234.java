package playcode.backtrackrecursiveplusmemory;

import playcode.common.ListNode;

public class PalindromeLinkedList234 {
    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        left= head;
        return check(head);
    }

    private boolean check(ListNode right){
        if(right ==null){
            return true;
        }
        //this code will visit the most right node first.
        //when it reach the most right node, the left is the head
        boolean isPal = check(right.next);
        if(!isPal) return false;
        if(left.val != right.val) return false;
        left = left.next;
        return true;
    }
}
