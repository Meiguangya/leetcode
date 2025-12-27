package main.java.hot100;

import main.java.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/12/23 下午12:44
 * @description 从前序和中序遍历构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class TreeBuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        if (preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> locationMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            locationMap.put(inorder[i], i);
        }


        TreeNode root = new TreeNode(preorder[0]);


        // 找出左子树的preorder和inorder
        // 计算左子树的大小
        Integer i = locationMap.get(preorder[0]);
        int leftSize = i;

        root.left = buildTree(getLeftPreOrder(preorder, leftSize), getLeftInOrder(inorder, leftSize));

        // 找出右子树的preorder和inorder
        root.right = buildTree(getRightPreOrder(preorder, leftSize), getRightInOrder(inorder, leftSize));

        return root;

    }

    private int[] getLeftPreOrder(int[] preorder, int size) {
        int start = 1;
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = preorder[i + start];
        }
        return ret;
    }

    private int[] getLeftInOrder(int[] inorder, int size) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = inorder[i];
        }
        return ret;
    }

    private int[] getRightPreOrder(int[] preorder, int leftSize) {
        int start = 1 + leftSize;
        int[] ret = new int[preorder.length - leftSize - 1];
        for (int i = start; i < preorder.length; i++) {
            ret[i - start] = preorder[i];
        }
        return ret;
    }

    private int[] getRightInOrder(int[] inorder, int leftSize) {
        int start = leftSize + 1;
        int[] ret = new int[inorder.length - leftSize - 1];
        for (int i = start; i < inorder.length; i++) {
            ret[i - start] = inorder[i];
        }
        return ret;
    }


    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeBuildTree demo = new TreeBuildTree();
        TreeNode treeNode = demo.buildTree(preorder, inorder);

    }

}
