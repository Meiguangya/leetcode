package main.java.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2024/12/24 上午10:53
 * @description TODO
 */
public class Solution_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, inOrderMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> inOrderMap,
                              int pre_left, int pre_right,
                              int inorder_left, int inorder_right) {

        if (pre_left == pre_right) {
            return new TreeNode(preorder[pre_left]);
        }

        if (pre_left > pre_right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre_left]);

        int inorder_root_index = inOrderMap.get(preorder[pre_left]);
        // 左子树的 pre_left，pre_right,inorder_left,inorder_right

        int left_tree_size = inorder_root_index - inorder_left;

        root.left = buildTree(preorder, inorder, inOrderMap,
                pre_left + 1, pre_left + left_tree_size,
                inorder_left, inorder_root_index - 1);

        root.right = buildTree(preorder, inorder, inOrderMap,
                pre_left + left_tree_size + 1, pre_right,
                inorder_root_index + 1, inorder_right);

        return root;
    }

    public static void main(String[] args) {
        Solution_105 solution_105 = new Solution_105();
        TreeNode root = solution_105.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

    }


}
