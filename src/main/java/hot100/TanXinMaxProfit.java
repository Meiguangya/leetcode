package main.java.hot100;

/**
 * @author meiguangya
 * @date 2025/12/22 下午10:03
 * @description 买卖股票的最佳时间
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class TanXinMaxProfit {


    /**
     * 一次遍历 记录最小的值 和最大的差值即可
     * 如果后续遍历的值小于最小的值 那么更新最小的值
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int max = 0;

        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                if (max < prices[i] - min) {
                    max = prices[i] - min;
                }
            } else {
                min = prices[i];
            }
        }

        return max;

    }


}
