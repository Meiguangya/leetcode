package main.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2024/12/23 下午2:20
 * @description 给你二叉树的根节点 root ，返回其节点值的 层序遍历
 */
public class Solution_102 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        List<List<Integer>> ret = new ArrayList<>();

        while (!nodeList.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            for (TreeNode treeNode : nodeList) {
                list.add(treeNode.val);
            }
            ret.add(list);

            List<TreeNode> next = new ArrayList<>();
            for (TreeNode treeNode : nodeList) {
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            nodeList = next;
        }

        return ret;
    }


}
