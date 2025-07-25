package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/7/23 下午7:46
 * @description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 */
@Slf4j
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {

        int[] ret = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        log.info("ret:[{}]", Arrays.toString(ret));

    }


}
