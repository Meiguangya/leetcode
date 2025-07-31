package main.java.SwordFingerOffer.tree.bst;

import lombok.extern.slf4j.Slf4j;
import main.java.SwordFingerOffer.tree.TreeNode;

import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/31 上午3:11
 * @description 二叉搜索树中第k小的元素
 * 可以用中序遍历 不过太简单了
 * 使用迭代试试
 */
@Slf4j
public class KthSmallest {


    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;
            if (count == k) {
                return curr.val;
            }

            curr = curr.right;
        }

        return curr.val;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);

        root.left = n2;
        root.right = n3;


        // TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        // n2.left = n4;
        n2.right = n5;

        //TreeNode n6 = new TreeNode(6);
        //TreeNode n7 = new TreeNode(7);
        //
        //n3.left = n6;
        //n3.right = n7;

        KthSmallest demo = new KthSmallest();
        int i = demo.kthSmallest(root, 1);

    }

}
