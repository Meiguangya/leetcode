package main.java.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/12/22 下午8:11
 * @description 合并区间
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 3：
 * <p>
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 */
public class ArrayMergeInterval {


    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });

        List<int[]> ans = new ArrayList<>();

        for (int[] arr : intervals) {

            int size = ans.size();

            if (size == 0) {
                ans.add(arr);
                continue;
            }

            int preNum = ans.get(size - 1)[1];
            if (arr[0] <= preNum && preNum <= arr[1]) {
                ans.get(size - 1)[1] = arr[1];
            } else if (preNum < arr[0]) {
                ans.add(arr);
            }

        }
        int[][] ret = new int[ans.size()][];
        ans.toArray(ret);
        return ret;
    }

    public static void main(String[] args) {

        ArrayMergeInterval demo = new ArrayMergeInterval();

        int[][] interval = {
                {1, 3},
                {2, 6},
                {15, 18},
                {8, 10},
        };

        int[][] merge = demo.merge(interval);
        System.out.println(merge.length);
    }


}
