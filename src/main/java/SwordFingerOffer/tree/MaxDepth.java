package main.java.SwordFingerOffer.tree;

/**
 * @author meiguangya
 * @date 2025/7/27 下午6:50
 * @description 树的最大深度
 */
public class MaxDepth {


    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));

    }


}
