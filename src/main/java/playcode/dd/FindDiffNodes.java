package playcode.dd;

import java.util.*;

/**
 * 一些判定规则如下（面试时请与面试官clarify，不要上来就说是这样，至少要会演）：
 * 1. 如果node key一样，value一样，视为同一个节点。
 * 2. 如果node key一样，value不同，视为不同节点，但树的结构保持不变。
 * 3. 如果node key不同，则视为完全不同的两棵树，答案应该返回这两棵树里一共有多少节点。
 * 4. children数组里的顺序无关。


我直接开始说思路，就是同时遍历两颗树， 改动的情况，分三种， deleted branch， added new branch， update node value。 说完，我和面试官确认思路，他有没有听懂，有没有问题。他说挺好的，然后我就是开始写了。
        写代码秒了，这个时候大概整个面试过去30分钟多一点。然后他提供了一个test case，他没有和我明说这个test case 的output应该是啥。我run 完我的代码，我以为他给的tree 是两个不同的tree，我的代码的method signature 是 isModfied(), 返回false，我就回头开始debug， 先把input 画出来，发现其实是两个一样的树，然后我再和他确认。他才告诉我说， 他以为signature 是 isIdentical(). 然后我再修改了两个例子，去cover 另外两种情况， deleted 和 added, 都没有问题。 所以算是bug free 吧。然后又问了问我corner case 的情况，我就说可以考虑万一两个点是null,或者其中一个点是null 的情况。然后再稍微改了改代码。
 */
//4. 两个树的遍历，先统计不同的节点数量，再对不同节点分类， 哪些点是添加，哪些点是更改，哪些点是删除。/
//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=779975&page=1#pid15770103
public class FindDiffNodes {
    static class TreeNode {
        int key;
        int val;
        List<TreeNode> children;
    }
        int diff =0;
        public int findDiffNodes(TreeNode root1, TreeNode root2) {
            if(root1 == root2) return 0;
            if(root1==null || root2 ==null){
                return 1;
            }
            List<TreeNode> children1 = root1.children;
            List<TreeNode> children2 = root2.children;
            if(children1!=null) Collections.sort(children1, (a,b)->a.val-b.val);
            if(children2!=null) Collections.sort(children2, (a,b)->a.val-b.val);
            return 0;
        }
    }
