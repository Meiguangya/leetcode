package main.java.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2024/12/27 下午4:24
 * @description TODO
 */
public class Solution_2553 {


    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            list.addAll(getNumList(nums[i]));

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public List<Integer> getNumList(int num){
        List<Integer> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.add(num % 10);
            num /= 10;
        }

        while (!stack.isEmpty()) {
            num = stack.pop();
            ret.add(num);
        }
        return ret;
    }

}
