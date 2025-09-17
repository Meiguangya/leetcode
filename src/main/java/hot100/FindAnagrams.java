package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author meiguangya
 * @date 2025/9/17 下午9:48
 * @description 找到字符串中所有字母的异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
@Slf4j
public class FindAnagrams {


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList<>();

        boolean f = false;

        for (int i = 0; i <= s.length() - p.length(); i++) {

            if (f && s.charAt(i - 1) == s.charAt(i + p.length() - 1)) {
                ret.add(i);
                continue;
            }

            String sub = s.substring(i, i + p.length());
            if (isAnagram(sub, p)) {
                ret.add(i);
                f = true;
            } else {
                f = false;
            }

        }

        return ret;
    }


    public boolean isAnagram(String s1, String s2) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            Integer v = map1.getOrDefault(s1.charAt(i), 0);
            map1.put(s1.charAt(i), v + 1);
        }

        for (int j = 0; j < s2.length(); j++) {
            Integer v = map2.getOrDefault(s2.charAt(j), 0);
            map2.put(s2.charAt(j), v + 1);
        }

        Set<Character> characters = map1.keySet();
        for (Character character : characters) {
            if (!map1.get(character).equals(map2.get(character))) {
                return false;
            }
        }

        return true;
    }


    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams3(String s, String p) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            ret.add(0);
        }

        for (int i = 1; i <= s.length() - p.length(); i++) {
            int left = i;
            int right = left + p.length() - 1;
            sCount[s.charAt(left - 1) - 'a']--;
            sCount[s.charAt(right) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ret.add(i);
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd",
                p = "abc";

        FindAnagrams demo = new FindAnagrams();
        log.info("start");
        List<Integer> anagrams = demo.findAnagrams2(s, p);
        log.info("end");
        log.info("anagrams:{}", anagrams);
    }

}
