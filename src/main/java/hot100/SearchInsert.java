package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

/**
 * @author meiguangya
 * @date 2025/7/23 下午9:17
 * @description TODO
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 */
@Slf4j
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }

            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }

            if (nums[mid] == target) {
                return mid;
            }

        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int ret = new SearchInsert().searchInsert(nums, target);
        log.info("ret:[{}]", ret);
    }

}
