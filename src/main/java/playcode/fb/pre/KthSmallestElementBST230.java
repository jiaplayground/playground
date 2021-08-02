package playcode.fb.pre;

import playcode.common.TreeNode;

public class KthSmallestElementBST230 {
    /**
     * This does not work as it k is not global value
     * public int kthSmallest(TreeNode root, int k ) { // int[] k = new int[1] should work
     *         if(root == null){
     *             return -1;
     *         }
     *         int left = kthSmallest(root.left, k);
     *         if(left >=0){
     *             return left;
     *         }
     *         if(--k==0){
     *             return root.val;
     *         }
     *         return kthSmallest(root.right, k);
     *     }
     */
    /**
     * No global variable
     *
     */
    int kthSmallest(TreeNode root, int k){
        return kthSmallest(root, new int[1], k);
    }
    private  int kthSmallest(TreeNode root, int[] count, int k) {
        if(root == null){
            return -1;
        }
        int left = kthSmallest(root.left,count, k);
        if(left >=0){
            return left;
        }
        count[0]++;
        if(count[0]==k){
            return root.val;
        }
        return kthSmallest(root.right,count, k);
    }


    private int count = 0;
    public int kthSmallestV2(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int left = kthSmallestV2(root.left, k);
        if(left >=0){
            return left;
        }
        if(++count==k){
            return root.val;
        }
        return kthSmallestV2(root.right, k);
    }

}
