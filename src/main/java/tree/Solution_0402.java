package main.java.tree;

import java.util.Arrays;

/**
 * @author meiguangya
 * @date 2024/12/31 上午11:26
 * @description 最小高度树
 */
public class Solution_0402 {


    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        int n = nums.length / 2;
        TreeNode root = new TreeNode();
        root.val = nums[n];

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,n));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,n+1,nums.length));
        return root;
    }

    public static void main(String[] args) {
        Solution_0402 solution_0402 = new Solution_0402();
        int[] nums = new int[]{-10,-3,0,5,9};

        TreeNode root = solution_0402.sortedArrayToBST(nums);
    }

}
