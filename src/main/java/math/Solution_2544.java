package main.java.math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author meiguangya
 * @date 2024/12/27 下午2:51
 * @description TODO
 */
public class Solution_2544 {


    public int alternateDigitSum(int n) {

        Deque<Integer> stack = new LinkedList<>();

        while (n > 0) {
            stack.addFirst(n % 10);
            n /= 10;
        }

        int res = 0;
        int i = -1;
        while (!stack.isEmpty()) {
            i = -i;
            res = res +  i * stack.poll();
        }

        return res;
    }


    public static void main(String[] args) {
        Solution_2544 solution_2544 = new Solution_2544();
        System.out.println(solution_2544.alternateDigitSum(10));
    }

}
