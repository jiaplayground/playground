package playcode.fb.pre;

import playcode.common.TreeNode;

import java.util.*;
public class SerializeDeserializeBinaryTree {

    private static final String SPLITOR=":";
    private static final String NULL = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null){
            return NULL + SPLITOR;
        }
        return root.val + SPLITOR + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        for(String val : data.split(SPLITOR)){
            if(val.equals(NULL)){
                queue.offer(null);
            }
            else {
                queue.offer(new TreeNode(Integer.parseInt(val)));
            }
        }
        return makeTree(queue);

    }
    // 1;2;N;N;3;4;N;5;N;N
    private TreeNode makeTree(Queue<TreeNode> queue){
        if(queue.isEmpty()){
            return null;
        }
        TreeNode root = queue.poll();
        //root =1;
        if(root ==null) {
            return null;
        }
        root.left = makeTree(queue); // left=> root 2
        root.right = makeTree(queue);
        return root;
    }

}
