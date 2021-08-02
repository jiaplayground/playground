package playcode.fb.pre;

import playcode.common.TreeNode;

public class SmallestSubtreeDeepestNodes865 {
    static class Result {
        TreeNode node;
        int level;

        Result(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        return dfs(root, 0).node;
    }

    private Result dfs(TreeNode node, int level) {
        if (node == null) return new Result(node, level);
        Result left = dfs(node.left, level);
        Result right = dfs(node.right, level);
        if (left.level == right.level) {
            return new Result(node, left.level + 1);
        }
        if (left.level > right.level) {
            return new Result(left.node, left.level + 1);
        }
        return new Result(right.node, right.level + 1);
    }


    public static void main(String[] args){
        for(int x=-10; x<20; x++){

            if(x<-4 || x>10 && x%2 ==0){
                System.out.println(x);
            }

        }

    }

}
