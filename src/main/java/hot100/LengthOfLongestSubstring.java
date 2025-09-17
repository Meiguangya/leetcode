package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/9/17 下午8:57
 * @description 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;

        while (right < s.length()) {

            if (map.containsKey(s.charAt(right))) {
                Integer i = map.get(s.charAt(right));
                left = Math.max(left,i+1);
                map.put(s.charAt(right),right);
            } else {
                map.put(s.charAt(right), right);
            }

            max = Math.max(right - left + 1, max);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();

        //String s = "abcabcbb";
        // String s = "bbbbb";
        String s = "abba";
        int ret = demo.lengthOfLongestSubstring(s);
        System.out.println(ret);
    }


}
