package main.java.SwordFingerOffer.tree;

/**
 * @author meiguangya
 * @date 2025/7/27 下午7:57
 * @description 对称二叉树  给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric2 {

    public boolean isSymmetric(TreeNode root) {

        return check(root.left, root.right);

    }

    public boolean check(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return check(left.left, right.right) && check(left.right, right.left);
        }

        return false;

    }



}
