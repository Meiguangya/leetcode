package main.java.tree;

import java.util.*;

/**
 * @author meiguangya
 * @date 2024/12/24 下午5:17
 * @description 二叉树的层序遍历2
 */
public class Solution_107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        List<List<Integer>> tmp = new ArrayList<>();

        while (!list.isEmpty()) {

            List<TreeNode> newList = new ArrayList<>();
            List<Integer> item = new ArrayList<>();
            for (TreeNode node : list) {
                item.add(node.val);
                if (node.left != null) {
                    newList.add(node.left);
                }

                if (node.right != null) {
                    newList.add(node.right);
                }
            }
            list = newList;

            tmp.add(item);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = tmp.size() - 1; i > 0; i--) {
            res.add(new ArrayList<>(tmp.get(i)));
        }

        return res;
    }

}
