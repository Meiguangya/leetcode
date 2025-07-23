package main.java.tree;

import main.java.entity.ListNode;

/**
 * @author meiguangya
 * @date 2024/12/30 上午10:56
 * @description 二叉树中的链表
 */
public class Solution_1367 {


    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSubPath(head, head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSubPath(ListNode head, ListNode node, TreeNode root) {

        if (node == null) {
            return true;
        }

        if (root == null) return false;

        ListNode nextNode;
        if (root.val == node.val) {
            nextNode = node.next;
            return isSubPath(head, nextNode, root.left) || isSubPath(head, nextNode, root.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode node_1_1 = new TreeNode(1);
        root1.right = node_1_1;

        TreeNode node1_1_10 = new TreeNode(10);
        node_1_1.left = node1_1_10;
        TreeNode node1_1_1 = new TreeNode(1);
        node_1_1.right = node1_1_1;

        TreeNode node1_1_10_9 = new TreeNode(9);
        node1_1_10.left = node1_1_10_9;

        ListNode head = new ListNode(1);
        ListNode node_1_10 = new ListNode(10);
        head.next = node_1_10;


        Solution_1367 demo = new Solution_1367();

        boolean subPath = demo.isSubPath(head, root1);
        System.out.println(subPath);

    }

}
