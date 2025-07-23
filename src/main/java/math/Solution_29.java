package main.java.math;

/**
 * @author meiguangya
 * @date 2024/12/26 上午10:37
 * @description 两数相除
 */
public class Solution_29 {

    public int divide(int dividend, int divisor) {

        boolean f = (dividend < 0 && divisor >0) || (dividend > 0 && divisor < 0);

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            dividend = dividend + 1;
        }

        int result = 0;

        while (Math.abs(dividend) >= Math.abs(divisor)) {

            if (dividend > 0 && divisor > 0) {
                dividend = dividend - divisor;
            }

            if(dividend < 0 && divisor < 0) {
                dividend = dividend - divisor;
            }

            if (dividend > 0 && divisor < 0) {
                dividend = dividend + divisor;
            }

            if (dividend < 0 && divisor > 0) {
                dividend = dividend + divisor;
            }

            if (result < Integer.MAX_VALUE) {
                result++;
            }
        }

        if (f) {
            return -result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {

        Solution_29 solution_29 = new Solution_29();

        System.out.println(solution_29.divide(-2147483648, -1));
        // System.out.println(solution_29.divide(1, -1));

    }

}
