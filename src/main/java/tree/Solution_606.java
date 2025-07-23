package main.java.tree;

/**
 * @author meiguangya
 * @date 2024/12/30 下午4:55
 * @description 根据二叉树创建字符串
 */
public class Solution_606 {


    public String tree2str(TreeNode root) {

        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if("".equals(root.left) && !"".equals(root.right)){
            sb.append("(").append(tree2str(root.left)).append(")");
        }

        if(!"".equals(tree2str(root.left))){
            sb.append("(").append(tree2str(root.left)).append(")");
        }
        if(!"".equals(tree2str(root.right))){
            sb.append("(").append(tree2str(root.right)).append(")");
        }

        return sb.toString();
    }


}
