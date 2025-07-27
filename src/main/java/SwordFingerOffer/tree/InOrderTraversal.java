package main.java.SwordFingerOffer.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/27 下午5:59
 * @description 树的中序遍历 使用迭代的方式
 */
@Slf4j
public class InOrderTraversal {


    public List<Integer> inorderTraversal(TreeNode root){

        if(root == null){
            return null;
        }

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while(curr != null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            ret.add(curr.val);
            curr = curr.right;
        }

        return ret;
    }


    public List<Integer> inorderTraversal2(TreeNode root){

        List<Integer> node = new ArrayList<>();

        dfs(root,node);
        return node;
    }

    public void dfs(TreeNode root, List<Integer> nodes) {

        if (root == null) {
            return;
        }

        dfs(root.left, nodes);
        nodes.add(root.val);
        dfs(root.right, nodes);

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

        InOrderTraversal demo = new InOrderTraversal();

        List<Integer> integers = demo.inorderTraversal(root);

        log.info("使用迭代ret:{}",integers);

        List<Integer> integers1 = demo.inorderTraversal2(root);

        log.info("使用递归ret:{}",integers1);

    }


}
