package main.java.hot100;

import main.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/12/26 下午9:59
 * @description 路径总和
 */
public class TreePathSum {

    int count = 0;
    List<TreeNode> list = new ArrayList<>();

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        inorder(root);

        for (TreeNode treeNode : list) {
            int n = pathSumFromCurrentNode(treeNode, targetSum);
            System.out.println(n + "--" + treeNode.val);
            count += n;
        }

        return count;
    }

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);

    }

    public int pathSumFromCurrentNode(TreeNode root, long targetSum) {

        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (targetSum == root.val) {
            sum += 1;
        }

        if (root.left != null) {
            sum += pathSumFromCurrentNode(root.left, targetSum - root.val);
        }

        if (root.right != null) {
            sum += pathSumFromCurrentNode(root.right, targetSum - root.val);
        }

        return sum;
    }

    public static void main(String[] args) {
        // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        TreeNode n1 = new TreeNode(1000000000);
        TreeNode n2 = new TreeNode(1000000000);
        TreeNode n3 = new TreeNode(294967296);
        TreeNode n4 = new TreeNode(1000000000);
        TreeNode n5 = new TreeNode(1000000000);
        TreeNode n6 = new TreeNode(1000000000);

        n1.left = n2;
        n1.right = null;
        n2.left = n3;
        n2.right = null;
        n3.left = n4;
        n3.right = null;
        n4.left = n5;
        n5.left = n6;

        TreePathSum t = new TreePathSum();
        int i = t.pathSum(n1, 0);

        System.out.println(i);

        int r = -1000000000-294967296;
        r = r - 1000000000;
        System.out.println(r);

    }


}
