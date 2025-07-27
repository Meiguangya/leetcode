package main.java.SwordFingerOffer.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/27 下午6:39
 * @description 树的后序遍历
 */
@Slf4j
public class PostOrderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> ret = new ArrayList<>();

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();

            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
            } else {
                curr = stack.pop();
                ret.add(curr.val);
                prev = curr;
                curr = null;
            }
        }

        return ret;

    }

    public static void main(String[] args) {

        // 构建一个简单的树
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        root.left = n2;
        root.right = n3;


        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n3.left = n6;
        n3.right = n7;

        PostOrderTraversal demo = new PostOrderTraversal();
        List<Integer> integers = demo.postorderTraversal(root);
        log.info("使用迭代ret:{}",integers);

    }

}
