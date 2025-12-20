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

    /**
     * 贪心 遍历元素 记录以当前元素为结尾的连续子数组的最大值 找出最大
     * 每次遍历时 如果之前的最大值大于0 那么加上当前元素 最为以当前元素为结尾的最大数
     * 否则就取当前元素值为最大的连续子数组的和
     * @param nums
     * @return
     */
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

    /**
     * 动态规划
     * f(i) = 以i结尾的最大数
     * f(0) = nums[0]
     * 每次遍历到元素i时，判断当前元素加上先前的最大值和不加上先前最大值哪个大，取大的作为当前元素的最大值
     * 然后用一个临时数 记录一路遍历过来的数 最终取最大数
     * @param nums
     * @return
     */
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
