package main.java.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author meiguangya
 * @date 2025/9/18 下午11:43
 * @description 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class MinWindow {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int sLen = s.length();
        int tLen = t.length();

        Map<Character, Integer> tCount = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> sCount = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        String ret = "";

        int left = 0;
        int right = 0;
        int match = 0;
        int start = 0;

        for (; right < sLen; right++) {

            char c = s.charAt(right);

            if (tCount.containsKey(c)) {
                sCount.put(c, sCount.getOrDefault(c, 0) + 1);
                if (sCount.get(c).equals(tCount.get(c))) {
                    match += 1;
                }
            }

            while (left <= right && match == tCount.size()) {
                // 移动左指针向右
                if (right - left + 1 <= minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char c1 = s.charAt(left);
                if (tCount.containsKey(c1)) {

                    if (sCount.get(c1).equals(tCount.get(c1))) {
                        match--;
                    }

                    sCount.put(c1, sCount.get(s.charAt(left)) - 1);
                }

                left++;
            }

        }

        return ret = minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }

    public boolean isContains(Map<Character,Integer> sCount,Map<Character,Integer> tCount){

        Set<Character> characterSet = tCount.keySet();

        for (Character c : characterSet) {
            if(sCount.getOrDefault(c,0) < tCount.get(c)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        MinWindow demo = new MinWindow();

        String s = "ADOBECODEBANC";
        String t = "ABC";

        s = "a";
        t = "a";

        String ret = demo.minWindow(s, t);

        System.out.println(ret);

    }

}
