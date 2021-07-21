package playcode.linkedlist;
import org.junit.jupiter.api.Test;
import playcode.common.ListNode;

import java.util.*;
public class ReverseNodesKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2) return head;
        int count =0;
        ListNode currNode = head;
        ListNode start = head;
        ListNode pre = null;
        ListNode result =null;
        while(currNode !=null){
            count++;
            if(count%k==0){
                if(count==k){
                    result = currNode;
                }
                ListNode nodeK = reverseKNode(pre, start, k);
                pre = nodeK;
                start = nodeK.next;
                currNode = start;
            }
            else {
                currNode = currNode.next;
            }
        }
        return result;
    }

    private ListNode reverseKNode(ListNode pre, ListNode head, int k){
        System.out.println(head.val+" start ::" + head.next.val);
        ListNode curr = head;
        ListNode preHead = pre;
        pre =null;
        while(k-- >0){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr=next;
        }
        if(preHead!=null){
            preHead.next = pre;
        }
        head.next = curr;
  //      System.out.println(head.val+" end ::"+ head.next.val);
        return head;
    }

    @Test
    void t(){
        ReverseNodesKGroup rg = new ReverseNodesKGroup();
        rg.reverseKGroup(ListNode.getListNode(), 2);
    }

}
