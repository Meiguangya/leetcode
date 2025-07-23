package main.java.tree;

import java.util.*;

/**
 * @author meiguangya
 * @date 2024/12/30 下午3:17
 * @description 二叉树中所有距离为K的点
 */
public class Solution_863 {

    Map<Integer, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left.val, node);
            }

            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right.val, node);
            }
        }

        List<Integer> res = new ArrayList<>();

        find(target, null,0, k, res);

        return res;
    }

    void find(TreeNode node, TreeNode from,int depth, int k, List<Integer> res) {

        if (node == null) {
            return;
        }

        if (depth == k) {
            res.add(node.val);
            return;
        }

        if (from != node.left) {
            find(node.left, node, depth + 1, k, res);
        }

        if (from != node.right) {
            find(node.right, node, depth + 1, k, res);
        }

        if (map.get(node.val) != from) {
            find(map.get(node.val),node,depth + 1, k, res);
        }


    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution_863 demo = new Solution_863();

        List<Integer> integers = demo.distanceK(root, root.left, 2);

        System.out.println(integers);

    }


}
