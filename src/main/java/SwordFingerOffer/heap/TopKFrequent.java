package main.java.SwordFingerOffer.heap;

import java.util.*;

/**
 * @author meiguangya
 * @date 2025/8/2 下午4:36
 * @description 前K个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (heap.size() < k) {
                heap.offer(entry);
                continue;
            }

            if (heap.peek().getValue() <= entry.getValue()) {
                heap.remove();
                heap.offer(entry);
            }
        }

        List<Integer> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : heap) {
            ret.add(e.getKey());
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }


}
