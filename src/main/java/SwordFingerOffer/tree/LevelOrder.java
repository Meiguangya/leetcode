package main.java.SwordFingerOffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author meiguangya
 * @date 2025/7/27 下午9:32
 * @description 树的层序遍历
 */
public class LevelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    newQueue.offer(node.left);
                }
                if (node.right != null) {
                    newQueue.offer(node.right);
                }
            }

            ret.add(list);
            queue = newQueue;
        }

        return ret;

    }

}
