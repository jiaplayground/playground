package playcode.treetrie;

import playcode.common.TreeNode;

public class ValidateBST98 {

    long min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= min) {
            return false;
        }
        min = root.val;
        return (isValidBST(root.right));
    }
}
