package main.java.SwordFingerOffer.tree.bst;

import main.java.SwordFingerOffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/28 下午3:48
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
public class ValidBST {


    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }


    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = inorderList(root);
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> inorderList(TreeNode root) {

        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            ret.add(curr.val);
            curr = curr.right;
        }

        return ret;
    }




    public static void main(String[] args) {

        // 构建一个简单的树
        TreeNode root = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(6);

        root.left = n2;
        root.right = n3;


        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);

        n3.left = n6;
        n3.right = n7;


        ValidBST demo = new ValidBST();

        demo.isValidBST(root);

    }


}
