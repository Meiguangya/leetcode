package main.java.SwordFingerOffer.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/7/28 上午12:14
 * @description 向下的路径节点值之和
 * 难度 中等偏高
 */
@Slf4j
public class PathSum {


    public int pathSum(TreeNode root,int sum){

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        return dfs(root,sum,map,0);
    }

    public int dfs(TreeNode root,int sum,Map<Integer,Integer> map,int path){

        if(root == null){
            return 0;
        }

        path = path + root.val;

        int count = map.getOrDefault(path - sum,0);
        map.put(path,map.getOrDefault(path,0)+1);

        count+=dfs(root.left,sum,map,path);
        count+=dfs(root.right,sum,map,path);

        map.put(path,map.get(path)-1);

        return count;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);

        root.left = n2;
        root.right = n3;


        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);

        n3.left = n6;
        n3.right = n7;


        PathSum demo = new PathSum();

        int i = demo.pathSum(root, 8);

        log.info("ret:{}",i);
    }


}
