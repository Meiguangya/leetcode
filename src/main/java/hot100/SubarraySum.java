package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/9/18 下午9:29
 * @description 和为K的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * 数组中有多少个数字之和等于K的连续子数组
 *
 *
 */
public class SubarraySum {


    /**
     * 使用一个map，key为子数组之和，value是和的数量
     * 假设第5个元素和为x,那么只要在第5个元素之前找到元素和为 x - k 的子数组，那么从这五个元素中取出这个子数组就是和为k的子数组了
     * 那就是只要找到元素和为 x - k 的子数组个数就行了
     * 从第一个元素开始遍历，使用map存取这个元素之和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        map.put(sum,1);
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }


}
