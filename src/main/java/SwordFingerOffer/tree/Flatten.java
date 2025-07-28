package main.java.SwordFingerOffer.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/28 下午5:32
 * @description 二叉树展开为链表
 */
@Slf4j
public class Flatten {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        List<TreeNode> list = preorderList(root);
        log.info("list1:{}",list);

        root = list.get(0);
        TreeNode curr = root;
        for(int i=1;i<list.size();i++){
            TreeNode node = list.get(i);
            curr.left = null;
            curr.right = node;
            curr = node;
        }

    }

    public List<TreeNode> preorderList(TreeNode root) {

        List<TreeNode> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                ret.add(curr);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }

        return ret;
    }

    public static void main(String[] args) {

        // 构建一个简单的树
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);

        root.left = n2;
        root.right = n3;


        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        n2.left = n4;
        n2.right = n5;

        TreeNode n7 = new TreeNode(6);

        n3.right = n7;

        Flatten demo = new Flatten();
        demo.flatten(root);

    }

}
