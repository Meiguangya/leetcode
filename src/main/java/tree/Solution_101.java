package main.java.tree;

/**
 * @author meiguangya
 * @date 2024/12/20 下午4:31
 * @description 对称二叉树
 */
public class Solution_101 {


    /**
     * 判断是否是对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        TreeNode leftInvert = invertTree(root.left);

        return isSameTree(root.right,leftInvert);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) return p == q;


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode newLeft = invertTree(root.left);
        TreeNode newRight = invertTree(root.right);

        root.left = newRight;
        root.right = newLeft;

        return root;
    }

    public static void main(String[] args) {

    }


}
