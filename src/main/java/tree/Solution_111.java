package main.java.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author meiguangya
 * @date 2024/12/25 下午3:15
 * @description 二叉树的最小高度
 */
public class Solution_111 {


    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        if(root.left == null){
            return 1+minDepth(root.right);
        }

        if(root.right == null){
            return 1+minDepth(root.left);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

    public int minDepth2(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            depth++;

        }
        return depth;

    }





}
