package main.java.hot100;

/**
 * @author meiguangya
 * @date 2026/1/3 下午2:12
 * @description 只出现一次的数字
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 *
 * 输入：nums = [2,2,1]
 *
 * 输出：1
 *
 * 输入：nums = [4,1,2,1,2]
 *
 * 输出：4
 *
 * 技巧 位运算
 * 异或  1.任何数和0异或都等于自己  5和0异或等于5  3和0异或等于3
 *      2.任何数和自身异或都等于0  5和5异或等于0
 *      3.异或具有交换律和结合律  5^3^5 == 5^5^3 = (5^5)^3 = 3
 *
 */
public class TrickSingleNumber {


    public int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums){
            single = single ^ num;
        }

        return single;
    }

    public static void main(String[] args) {

        int i = 5 ^ 3;
        System.out.println(i);
        i = 5 ^ 5;
        System.out.println(i);
        i = 5 ^ 3 ^ 5;
        System.out.println(i);



    }


}
