package main.java.SwordFingerOffer.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * @author meiguangya
 * @date 2025/7/24 下午8:12
 * @description 给一个递增的数组和一个值target, 找出数组中和为target的下标
 * [1,2,4,6,10]   target=8  输出[0,3]
 */
@Slf4j
public class TwoSum {


    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {

            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            }

            if (sum < target) {
                left += 1;
            }

            if (sum > target) {
                right -= 1;
            }

        }

        return null;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 6, 10};
        int target = 11;

        int[] ints = new TwoSum().twoSum(arr, target);
        log.info("ret:{}", ints);
    }

}
