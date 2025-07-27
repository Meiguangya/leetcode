package main.java.SwordFingerOffer.tree;

/**
 * @author meiguangya
 * @date 2025/7/27 下午11:33
 * @description 二叉树剪枝
 * 一颗二叉树的所有节点的值要么是0 要么是1
 * 请剪除所有值为0的子树
 */
public class PruneTree {


    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;

    }


}
