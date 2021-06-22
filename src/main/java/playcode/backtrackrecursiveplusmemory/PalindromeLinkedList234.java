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
        boolean isPal = check(right.next);
        if(!isPal) return false;
        if(left.val != right.val) return false;
        left = left.next;
        return true;
    }
}
