package main.java.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author meiguangya
 * @date 2024/12/20 下午5:23
 * @description 翻转二叉树
 */
@Slf4j
public class Solution_226 {


    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode newLeft = invertTree(root.left);
        TreeNode newRight = invertTree(root.right);

        root.left = newRight;
        root.right = newLeft;

        return root;
    }

    public static void main(String[] args) {
        Solution_226 solution = new Solution_226();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode treeNode = solution.invertTree(root);
        log.info("{}", root);
        log.info("{}", treeNode);
    }


}
