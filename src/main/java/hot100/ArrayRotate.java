package main.java.hot100;

/**
 * @author meiguangya
 * @date 2025/12/22 下午10:20
 * @description 轮转数组
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class ArrayRotate {


    /**
     * for循环 一次次轮转 效率慢 容易超时
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        if (k == 0) {
            return;
        }

        for (int i = 1; i <= k; i++) {
            int j = nums.length - 1;
            int temp = nums[nums.length - 1];
            while (j > 0) {
                nums[j] = nums[j - 1];
                j--;
            }

            nums[0] = temp;
        }

    }


    /**
     * 创建一个额外的数组存储 然后替换原始的值
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {

        k = k % nums.length;

        if (k == 0) {
            return;
        }

        int[] newNums = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            if (i <= k - 1) {
                newNums[i] = nums[nums.length - k + i];
            }

            if (i >= k) {
                newNums[i] = nums[i - k];
            }
        }


        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

    }


    /**
     * 选反转整个数组
     * 然后反转前K的元素
     * 然后反转后K个元素
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k){

        k = k % nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }



    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }



}
