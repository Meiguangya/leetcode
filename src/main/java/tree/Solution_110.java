package main.java.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author meiguangya
 * @date 2024/12/25 下午2:38
 * @description TODO
 */
public class Solution_110 {


    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        //int leftLevel = treeLevel(root.left);
        //int rightLevel = treeLevel(root.right);
        //
        //if(Math.abs(leftLevel - rightLevel) > 1) return false;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }


    public int height(TreeNode root) {

        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;

    }



    public int treeLevel(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            level++;
        }

        return level;
    }


    public static void main(String[] args) {

        Solution_110 solution_110 = new Solution_110();

        TreeNode root = new TreeNode(1);

        TreeNode leftNode = new TreeNode(2);
        leftNode.left = new TreeNode(3);
        leftNode.left.left = new TreeNode(4);

        int i = solution_110.treeLevel(leftNode);
        System.out.println(i);

        TreeNode rightNode = new TreeNode(2);
        rightNode.right = new TreeNode(3);
        rightNode.right.right = new TreeNode(4);
        i = solution_110.treeLevel(rightNode);
        System.out.println(i);

        root.left = leftNode;
        root.right = rightNode;
        System.out.println(solution_110.treeLevel(root));
        System.out.println(solution_110.isBalanced(root));
    }

}
