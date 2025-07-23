package main.java.array;

/**
 * @author meiguangya
 * @date 2024/12/27 下午4:06
 * @description 最小公共
 */
public class Solution_2540 {

    public int getCommon(int[] nums1, int[] nums2) {

        int index = 0;
        for (int i = 0; i < nums1.length; i++) {

            for (int j = index; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    return nums1[i];
                }

                if (nums1[i] < nums2[j]) {
                    index = j;
                    break;
                }
            }

        }
        return -1;

    }

}
