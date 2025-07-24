package main.java.SwordFingerOffer.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/7/24 下午8:32
 * @description 给一个数组 找出数组中所有和为0的3个数字的三元组 返回值不包含重复的三元组
 * [-1,0,1,2,-1,-4] =>  [-1,0,1] , [-1,-1,2]
 */
@Slf4j
public class SumZero {


    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return null;
        }

        // 排序
        Arrays.sort(nums);
        log.info("sort arr:[{}]", nums);

        int i = 0;
        List<List<Integer>> ret = new ArrayList<>();
        while (i < nums.length - 2) {
            twoSum(nums, i, ret);

            int temp = nums[i];
            while (i < nums.length && temp == nums[i]) {
                i++;
            }

        }

        return ret;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> list) {

        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int tmp = nums[j];
                while (j < k && tmp == nums[j]) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else if (nums[i] + nums[j] + nums[k] > 0) {
                k--;
            }
        }

    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ret = new SumZero().threeSum(nums);

        log.info("ret::{}", ret);
    }


}
