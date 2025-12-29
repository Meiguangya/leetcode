package main.java.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/12/28 下午9:22
 * @description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class BackTrackSubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    void helper(int[] nums, int index, List<Integer> subSet, List<List<Integer>> list) {

        if (index == nums.length) {
            list.add(subSet);
            return;
        } else {
            helper(nums, index + 1, new ArrayList<>(subSet), list);

            subSet.add(nums[index]);
            helper(nums, index + 1, new ArrayList<>(subSet), list);
        }

    }

    public static void main(String[] args) {

        BackTrackSubSet bs = new BackTrackSubSet();
        int[] nums = {1,2};
        List<List<Integer>> subsets = bs.subsets(nums);
        System.out.println(subsets.size());
    }


}
