package main.java.string;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author meiguangya
 * @date 2025/7/25 上午2:00
 * @description 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 输入：["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出：
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
@Slf4j
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = changeStr(str);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }

        List<List<String>> ret = new ArrayList<>();
        map.forEach((k, v) -> {
            ret.add(v);
        });

        return ret;
    }

    public boolean isAnagrams(String str1, String str2) {

        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        String s1 = new String(arr1);

        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr2);
        String s2 = new String(arr2);

        return s1.equals(s2);
    }

    public String changeStr(String str) {
        char[] arr1 = str.toCharArray();
        Arrays.sort(arr1);
        return new String(arr1);
    }

    public static void main(String[] args) {
        char[] ch = {'a', 'b'};
        String s = new String(ch);
        log.info("{}", s);

        GroupAnagrams demo = new GroupAnagrams();
        boolean f = demo.isAnagrams("abc", "cbaaa");
        log.info("isAnagrams:{}", f);

        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = demo.groupAnagrams(strArr);
        log.info("ret:{}",lists);
    }

}
