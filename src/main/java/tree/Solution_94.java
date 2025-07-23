package main.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2024/12/23 下午4:53
 * @description 中序遍历
 */
public class Solution_94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;
    }



}
