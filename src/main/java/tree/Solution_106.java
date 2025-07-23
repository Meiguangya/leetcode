package main.java.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2024/12/24 下午3:46
 * @description TODO
 */
public class Solution_106 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> map,
                              int in_left, int in_right,
                              int post_left, int post_right) {

        if (in_left == in_right) {
            return new TreeNode(inorder[in_left]);
        }

        if (in_right < in_left) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[post_right]);

        Integer in_root_index = map.get(postorder[post_right]);


        root.right = buildTree(inorder, postorder, map,
                in_root_index + 1, in_right,
                post_right - in_right + in_root_index,post_right - 1);

        root.left = buildTree(inorder, postorder, map, in_left,
                in_root_index - 1, post_left,
                post_right - in_right + in_root_index - 1);

        return root;

    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        Solution_106 solution_106 = new Solution_106();
        TreeNode root = solution_106.buildTree(inorder, postorder);
    }


}
