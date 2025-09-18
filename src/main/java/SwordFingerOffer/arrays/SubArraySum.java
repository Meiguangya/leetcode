package main.java.SwordFingerOffer.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/7/24 下午10:07
 * @description 输入一个整数数组和一个整数K 请问数组中有多少个数字之和等于K的连续子数组
 * [1,1,1] k=2  2个 [1,1] [1,1]
 * [1,0,-1,3,1] k=2 1个 [-1,3]
 */
@Slf4j
public class SubArraySum {


    public int subArraySum(int[] nums,int k){

        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }

        return count;

    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] nums = {1,0,-1,3,1};
        int k = 2;
        int i = subArraySum.subArraySum(nums, k);
        log.info("ret:[{}]",i);
    }

}
