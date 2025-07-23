package main.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author meiguangya
 * @date 2024/12/27 上午9:49
 * @description 查询数组中元素的出现位置
 */
public class Solution_3159 {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > list.size()) {
                res[i] = -1;
            } else {
                res[i] = list.get(queries[i] - 1);
            }
        }

        return res;

    }


    public static void main(String[] args) {
        Solution_3159 solution = new Solution_3159();
        //int[] nums = {3,1};
        //int[] queries = {2,1,2,3,2,3,3};
        //int x = 1;

        int[] nums = {1, 2, 2, 2};
        int[] queries = {3, 3, 4, 2, 2, 2};
        int x = 2;

        int[] res = solution.occurrencesOfElement(nums, queries, x);
        System.out.println(Arrays.toString(res));
    }


}
