package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author meiguangya
 * @date 2026/1/4 下午5:49
 * @description 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
@Slf4j
public class BackTrackCombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();

        backtrack(ans, 0, candidates, 0, new ArrayList<>(), target);

        return ans;
    }

    public void backtrack(List<List<Integer>> list, int index, int[] candidates, int sum, List<Integer> combination, int target) {

        if (sum == target) {
            list.add(combination);
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            sum = sum + candidates[i];
            ArrayList<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(candidates[i]);
            backtrack(list, i, candidates, sum, newCombination, target);
            sum = sum - candidates[i];
        }

    }

    public static void main(String[] args) {

        BackTrackCombinationSum b = new BackTrackCombinationSum();
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = b.combinationSum(candidates, target);

        log.info("list:[{}]", lists);

    }


}
