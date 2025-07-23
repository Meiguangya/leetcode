package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author meiguangya
 * @date 2025/7/23 下午4:40
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 */
@Slf4j
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        // int[] nums = {1, 0, 0, 3, 12};
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums,left,right);
                left++;
            }
            right++;
        }

        log.info("nums:[{}]", Arrays.toString(nums));
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
         int[] nums = {1, 0, 0, 3, 12};
        //int[] nums = {0, 0, 1};

        // new MoveZeroes().swap(nums, 0, 1);
        // log.info("nums: {}", Arrays.toString(nums));

        new MoveZeroes().moveZeroes(nums);
    }

}
