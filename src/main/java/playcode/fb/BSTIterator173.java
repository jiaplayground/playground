package playcode.fb;

import java.util.*;

import playcode.common.TreeNode;

public class BSTIterator173 {
    private Deque<TreeNode> stack;
    public BSTIterator173(TreeNode root) {
        stack = new ArrayDeque<>();
        fillLeft(root);
    }
    //7, 3; 3X ; 7X 15;9; 9X; 15X 20; 20X
    public int next() {
        if(stack.isEmpty()){
            return -1;
        }
        TreeNode currNode = stack.pop();
        int result = currNode.val;
        fillLeft(currNode.right);
        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void fillLeft(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
}
