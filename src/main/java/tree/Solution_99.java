package main.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2024/12/30 下午2:47
 * @description 恢复二叉搜索树
 */
public class Solution_99 {


    public void recoverTree(TreeNode root) {

        List<TreeNode> nodeList = new ArrayList<>();

        inorder(root, nodeList);

        int a1 = -1;
        int a2 = -1;
        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).val > nodeList.get(i + 1).val) {
                if (a1 == -1) {
                    a1 = i;
                } else {
                    a2 = i;
                }
            }
        }

        if (a2 != -1) {
            TreeNode n1 = nodeList.get(a1);
            TreeNode n2 = nodeList.get(a2+1);

            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }else{
            TreeNode n1 = nodeList.get(a1);
            TreeNode n2 = nodeList.get(a1+1);
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }
    }

    public void inorder(TreeNode root, List<TreeNode> nodeList) {

        if (root == null) return;

        if (root.left != null) {
            inorder(root.left, nodeList);
        }

        nodeList.add(root);

        if (root.right != null) {
            inorder(root.right, nodeList);
        }
    }

    public static void main(String[] args) {
        Solution_99 demo = new Solution_99();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        demo.recoverTree(root);
    }

}
