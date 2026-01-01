package main.java.hot100;

/**
 * @author meiguangya
 * @date 2026/1/1 下午3:59
 * @description 跳跃游戏2
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 * <p>
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 * <p>
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class TanXinJump {


    public int jump(int[] nums) {

        int max = 0;
        int step = 0;
        int curStepMax = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == curStepMax) {
                step++;
                curStepMax = max;
            }

        }

        return step;

    }

}
