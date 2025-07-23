package main.java.string;

/**
 * @author meiguangya
 * @date 2024/12/26 上午10:17
 * @description 字符串及其反转中是否存在同一子串
 *
 */
public class Solution_3083 {

    public boolean isSubstringPresent(String s) {

        String reverse = reverseString(s);

        for (int i = 0; i < reverse.length() - 1; i++) {

            String sub = reverse.substring(i, i + 2);

            for (int j = 0; j < s.length() - 1; j++) {
                String tmp = s.substring(j, j + 2);
                if (sub.equals(tmp)) {
                    return true;
                }
            }

        }

        return false;
    }

    public String reverseString(String s) {

        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public String reverseString1(String s) {
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_3083 demo = new Solution_3083();
        String s = "leetcode";
        System.out.println(demo.reverseString(s));

        System.out.println(s.substring(0,1));
    }

}
