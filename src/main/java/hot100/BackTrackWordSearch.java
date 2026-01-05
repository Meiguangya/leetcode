package main.java.hot100;

/**
 * @author meiguangya
 * @date 2026/1/5 下午3:48
 * @description 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class BackTrackWordSearch {


    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean result = dfs(board, i, j, 0, word);
                if (result) {
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * 从 board[row][col]开始 判断是否有单词word
     *
     * @param board
     * @param row
     * @param col
     * @param index
     * @param word
     * @return
     */
    private boolean dfs(char[][] board, int row, int col, int index, String word) {

        if (index == word.length()) {
            return true;
        }

        // 越界
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // 字符不匹配
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        // 标记当前位置已访问 防重
        board[row][col] = '*';

        // 继续寻找 index+1
        // 向左找
        boolean b1 = dfs(board, row, col + 1, index + 1, word);
        // 向右找
        boolean b2 = dfs(board, row, col - 1, index + 1, word);
        // 向下找
        boolean b3 = dfs(board, row + 1, col, index + 1, word);
        // 向上找
        boolean b4 = dfs(board, row - 1, col, index + 1, word);

        // 还原
        board[row][col] = temp;

        return b1 || b2 || b3 || b4;

    }


}
