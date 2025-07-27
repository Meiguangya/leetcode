package main.java.SwordFingerOffer.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/27 下午6:14
 * @description 树的前序遍历
 */
@Slf4j
public class PreOrderTraversal {


    public List<Integer> preOrderTraversal(TreeNode root){

        if(root == null){
            return null;
        }

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                ret.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }


        return ret;
    }

    public List<Integer> preOrderTraversal2(TreeNode root){
        List<Integer> nodes = new ArrayList<>();
        dfs(root,nodes);
        return nodes;
    }

    public void dfs(TreeNode node,List<Integer> nodes){

        if(node == null){
            return;
        }

        nodes.add(node.val);
        dfs(node.left,nodes);
        dfs(node.right,nodes);

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

        PreOrderTraversal demo = new PreOrderTraversal();
        List<Integer> ret = demo.preOrderTraversal(root);

        log.info("使用迭代ret:{}",ret);

        ret = demo.preOrderTraversal2(root);
        log.info("使用递归ret:{}",ret);

    }


}
