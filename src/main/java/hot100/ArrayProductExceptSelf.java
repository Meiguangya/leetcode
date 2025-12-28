package main.java.hot100;

/**
 * @author meiguangya
 * @date 2025/12/28 下午8:37
 * @description 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
public class ArrayProductExceptSelf {


    public int[] productExceptSelf(int[] nums) {

        // 使用两个辅助数组存储当前元素左边所有元素的乘积，和当前元素右边的所有元素乘积。

        int[] l = new int[nums.length];
        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        int[] r = new int[nums.length];
        r[nums.length - 1] = 1;
        for (int i = r.length - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = l[i] * r[i];
        }

        return ans;
    }


    public int[] productExceptSelf2(int[] nums) {

        // 使用O(1)的复杂度
        // 先保存当前元素左边所有元素的乘积
        // 在反向遍历 使用一个变量保持右边的乘积，去乘以当前的乘积。

        int[] ans = new int[nums.length];
        ans[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }

        int r = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }

        return ans;
    }



    public static void main(String[] args) {
        ArrayProductExceptSelf r = new ArrayProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] ints = r.productExceptSelf2(nums);
        System.out.println(ints.length);
    }

}
