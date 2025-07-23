package main.java.array;

/**
 * @author meiguangya
 * @date 2024/12/27 下午2:18
 * @description TODO
 */
public class Solution_2535 {


    public int differenceOfSum(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            ans += Math.abs(sum - nums[i]);
        }

        return ans;
    }

    public int sum(int num) {

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_2535 solution_2535 = new Solution_2535();

        // System.out.println(solution_2535.sum(115));

        System.out.println(Math.pow(10,2));

    }

}
