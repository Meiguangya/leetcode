package main.java.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author meiguangya
 * @date 2025/12/25 下午5:08
 * @description 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class MatrixSetZeros {


    /**
     * 第一次遍历收集存在0的行和存在0的列
     * 第二次遍历 更改对应的值
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m+n)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {

        int x = 1;
        int y = 2;

        x = y = 3;
        System.out.println(x);
        System.out.println(y);

        int[][] demo = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        MatrixSetZeros m = new MatrixSetZeros();
        m.setZeroes(demo);
        System.out.println(demo);
    }


}
