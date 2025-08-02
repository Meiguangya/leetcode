package main.java.SwordFingerOffer.heap;

import java.util.PriorityQueue;

/**
 * @author meiguangya
 * @date 2025/8/2 下午4:27
 * @description 数组中第K大的元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class FindKthLargest {


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            if(heap.size() < k){
                heap.offer(num);
                continue;
            }

            if(heap.peek() >= num){
                continue;
            }
            heap.remove();
            heap.offer(num);
        }

        return heap.peek();

    }

    public static void main(String[] args) {
        FindKthLargest demo = new FindKthLargest();
        int[] nums = {-1,2,0};
        int k = 2;
        demo.findKthLargest(nums,k);
    }

}
