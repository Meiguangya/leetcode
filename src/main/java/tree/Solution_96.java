package main.java.tree;

/**
 * @author meiguangya
 * @date 2024/12/23 下午6:25
 * @description 不同的二叉搜索树
 */
public class Solution_96 {


    public int numTrees(int n) {

        if (n <= 1) {
            return 1;
        }

        int num = 0;
        for (int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            num += numTrees(left) * numTrees(right);
        }

        return num;
    }

}
