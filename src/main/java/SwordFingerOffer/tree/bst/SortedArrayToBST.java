package main.java.SwordFingerOffer.tree.bst;

import main.java.SwordFingerOffer.tree.TreeNode;

/**
 * @author meiguangya
 * @date 2025/7/28 下午3:35
 * @description 将有序数组转换成二叉搜索树
 * nums = [-10,-3,0,5,9]
 *
 */
public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length-1);
    }

    public TreeNode getTree(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }




}
