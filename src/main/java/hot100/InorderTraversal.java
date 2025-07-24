package main.java.hot100;

import lombok.extern.slf4j.Slf4j;
import main.java.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/7/23 下午11:39
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
@Slf4j
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList();
        if (root == null) {
            return ret;
        }

        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));
        return ret;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = null;

        r.right = new TreeNode(2);
        r.right.left = new TreeNode(3);
        r.right.right = null;

        List<Integer> integers = new InorderTraversal().inorderTraversal(r);
        log.info("{}",integers);
    }





}
