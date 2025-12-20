package main.java.hot100;

/**
 * @author meiguangya
 * @date 2025/12/19 下午9:16
 * @description 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int max = nums[0];

        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMaxSum;
            if (preSum > 0) {
                curMaxSum = preSum + nums[i];
            } else {
                curMaxSum = nums[i];
            }


            if (curMaxSum > max) {
                max = curMaxSum;
            }
            preSum = curMaxSum;
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {

        int preMaxSum = 0;
        int max = nums[0];

        for(int x : nums){
            int maxSum = Math.max(x,preMaxSum+x);
            max = Math.max(maxSum,max);
            preMaxSum = maxSum;
        }

        return max;

    }


    public int maxSubArray3(int[] nums) {

        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }



    public static void main(String[] args) {

        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-1};
        MaxSubArray demo = new MaxSubArray();
        int i = demo.maxSubArray2(nums);
        System.out.println(i);

    }


}
