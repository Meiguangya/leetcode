package main.java.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author meiguangya
 * @date 2025/12/27 下午9:11
 * @description 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class BackTrackPermute {


    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }

        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numsList.size(); i++) {
            Integer num = numsList.get(i);
            List<Integer> newList = new ArrayList<>(numsList);
            newList.remove(num);

            int[] arr = newList.stream().mapToInt(Integer::intValue).toArray();

            for (List<Integer> item : permute(arr)) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                list.addAll(item);
                ans.add(list);
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        BackTrackPermute b = new BackTrackPermute();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = b.permute(nums);
        System.out.println(permute.size());
        System.out.println("over");

    }

}
