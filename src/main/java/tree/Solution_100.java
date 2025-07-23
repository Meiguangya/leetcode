package main.java.tree;

/**
 * @author meiguangya
 * @date 2024/12/20 下午5:03
 * @description 相同二叉树
 */
public class Solution_100 {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) return p == q;


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
