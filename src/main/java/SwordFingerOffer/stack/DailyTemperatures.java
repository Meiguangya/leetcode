package main.java.SwordFingerOffer.stack;

import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/31 下午9:13
 * @description 每日温度
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {

        int[] ret = new int[temperatures.length];

        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {

                int pre = indexStack.pop();
                ret[pre] = i - pre;

            }

            indexStack.push(i);

        }

        return ret;

    }

}
