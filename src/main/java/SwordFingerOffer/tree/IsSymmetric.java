package main.java.SwordFingerOffer.tree;

/**
 * @author meiguangya
 * @date 2025/7/27 下午7:57
 * @description 对称二叉树  给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        TreeNode convert = convert(root.left);

        return same(convert, root.right);

    }

    public TreeNode convert(TreeNode node) {

        if (node == null) {
            return null;
        }

        node.left = convert(node.left);
        node.right = convert(node.right);

        return node;
    }

    // 判断两个树是相同的
    public boolean same(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 != null && t2 != null) {
            if (t1.val != t2.val) {
                return false;
            }

            return same(t1.left, t2.left) && same(t1.right, t2.right);
        }

        return false;

    }


}
