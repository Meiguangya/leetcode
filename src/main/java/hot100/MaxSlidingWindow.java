package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author meiguangya
 * @date 2025/9/18 下午9:41
 * @description 滑动窗口的最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 */
@Slf4j
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        int[] ret = new int[len-k+1];
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= len - k; i++) {
            if (maxIndex == -1) {
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            ret[i] = max;
            if (i == maxIndex) {
                maxIndex = -1;
                max = Integer.MIN_VALUE;
            }
        }

        return ret;

    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    public int[] maxSlidingWindow4(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        int[] ret = new int[nums.length - k + 1];

        ret[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            while (deque.peek() < i - k + 1) {
                deque.poll();
            }

            ret[i - k + 1] = nums[deque.peek()];
        }

        return ret;

    }


    public static void main(String[] args) {
        MaxSlidingWindow demo = new MaxSlidingWindow();

        //int[] nums = {1,2,3,4,5,6,7,8};
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = demo.maxSlidingWindow3(nums, k);


    }

}
