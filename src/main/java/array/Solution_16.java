package main.java.array;

import java.util.Arrays;

/**
 * @author meiguangya
 * @date 2024/12/25 下午6:36
 * @description TODO
 */
public class Solution_16 {


    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ret = 0;
        int sum = 0;
        for (int first = 0; first < nums.length; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) continue;

            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {

                if (second > first + 1 && nums[second] == nums[second - 1]) continue;

                while (second < third) {
                    sum = nums[first] + nums[second] + nums[third];
                    if (sum == target) {
                        return target;
                    }
                    int diff = Math.abs(sum - target);
                    if (min > diff) {
                        min = diff;
                        ret = sum;
                    }
                    third--;
                }

            }

        }
        return ret;

    }

    public static void main(String[] args) {

        Solution_16 solution_16 = new Solution_16();
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(solution_16.threeSumClosest(nums, target));

    }

}
