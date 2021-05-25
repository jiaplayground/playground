package playcode.treetrie;

import playcode.common.TreeNode;

import java.util.*;

public class TreePath257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        visit(root, result, "");
        return result;
    }

    private void visit(TreeNode node, List<String> result, String curr) {
        if (node.left == null && node.right == null) {
            if (curr.isEmpty()) {
                result.add("" + node.val);
            } else result.add(curr + "->" + node.val);
            return;
        }
        if (!curr.isEmpty()) {
            curr += "->";
        }
        curr += node.val;
        if (node.left != null) visit(node.left, result, curr);
        if (node.right != null) visit(node.right, result, curr);
    }
}
