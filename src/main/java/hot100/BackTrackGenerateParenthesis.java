package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2026/1/4 下午10:27
 * @description 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
@Slf4j
public class BackTrackGenerateParenthesis {


    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(ans, 1, 0, n, new StringBuffer("("));

        return ans;
    }

    private void backtrack(List<String> ans, int countLeft, int countRight, int n, StringBuffer sb) {

        if (countLeft == n && countRight == n) {
            ans.add(sb.toString());
            return;
        }

        if (countRight > countLeft) {
            return;
        }

        if (countLeft > n || countRight > n) {
            return;
        }

        if (countLeft < n) {
            sb.append("(");
            backtrack(ans, countLeft + 1, countRight, n, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            backtrack(ans, countLeft, countRight + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (countLeft == n) {
            sb.append(")");
            backtrack(ans, countLeft, countRight + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    public static void main(String[] args) {

        BackTrackGenerateParenthesis b = new BackTrackGenerateParenthesis();
        List<String> list = b.generateParenthesis(3);
        log.info("[{}]", list);
    }


}
