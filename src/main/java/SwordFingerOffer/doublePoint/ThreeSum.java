package main.java.SwordFingerOffer.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/8/3 下午10:11
 * @description 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; ) {

            int target = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            int in = nums[i];

            while (left < right) {
                int ln = nums[left];
                int rn = nums[right];
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(list);
                    while (left < right && nums[left] == ln) {
                        left++;
                    }

                    while (left < right && nums[right] == rn) {
                        right--;
                    }
                    continue;
                }

                if (sum < target) {
                    while (left < right && nums[left] == ln) {
                        left++;
                    }
                }

                if (sum > target) {
                    while (left < right && nums[right] == rn) {
                        right--;
                    }
                }
            }

            while (i < nums.length - 2 && nums[i] == in) {
                i++;
            }

        }

        return ret;
    }

    public static void main(String[] args) {

        ThreeSum demo = new ThreeSum();

        // int[] nums = {-1,0,1,2,-1,-4};
        // int[] nums = {0,0,0};
        int[] nums = {-2,-3,0,0,-2};
        demo.threeSum(nums);

    }


}
