package main.java.tree;

import java.util.*;

/**
 * @author meiguangya
 * @date 2024/12/23 下午2:20
 * @description 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历
 */
public class Solution_103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();


        boolean fromLeft2Right = true;

        Stack<List<TreeNode>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        stack.push(list);

        List<List<Integer>> ret = new ArrayList<>();

        while (!stack.isEmpty()) {

            while (!stack.isEmpty()) {
                List<TreeNode> pop = stack.pop();
                queue.addAll(pop);
            }

            List<Integer> tmp = new ArrayList<>();

            fromLeft2Right = !fromLeft2Right;

            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                List<TreeNode> pair = new ArrayList<>();

                if (fromLeft2Right) {
                    if (poll.left != null) pair.add(poll.left);
                    if (poll.right != null) pair.add(poll.right);
                }else{
                    if (poll.right != null) pair.add(poll.right);
                    if (poll.left != null) pair.add(poll.left);
                }

                if (!pair.isEmpty()) {
                    stack.push(pair);
                }
            }

            ret.add(tmp);
        }

        return ret;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        boolean fromLeft2Right = true;

        while (!level.isEmpty()) {

            List<Integer> tmp = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();

            if (fromLeft2Right) {
                for (int i = 0; i < level.size(); i++) {
                    tmp.add(level.get(i).val);
                }
            } else {
                for (int i = level.size() - 1; i >= 0; i--) {
                    tmp.add(level.get(i).val);
                }
            }

            res.add(tmp);

            for (TreeNode treeNode : level) {
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }

            level = nextLevel;
            fromLeft2Right = !fromLeft2Right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution_103 solution_103 = new Solution_103();
        System.out.println(solution_103.zigzagLevelOrder(root));

    }


}
