package main.java.tree;

/**
 * @author meiguangya
 * @date 2024/12/27 下午4:48
 * @description TODO
 */
public class Solution_98 {


    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root, long min, long max) {

        if (root == null) return true;

        int v = root.val;

        return v > min && v < max && isValidBST2(root.left, min, v) && isValidBST2(root.right, v, max);

    }



    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        if (root.left != null && root.val <= root.left.val) {
            return false;
        }

        if (root.right != null && root.val >= root.right.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right) && largestInTree(root.val, root.left) && smallInTree(root.val, root.right);

    }

    public boolean smallInTree(int v, TreeNode root) {

        if (root == null) return true;

        if (root.val <= v) {
            return false;
        }

        return smallInTree(v, root.left) && smallInTree(v, root.right);
    }

    public boolean largestInTree(int v,TreeNode root) {
        if (root == null) return true;

        if(root.val >= v){
            return false;
        }

        return largestInTree(v, root.left) && largestInTree(v, root.right);

    }



}
