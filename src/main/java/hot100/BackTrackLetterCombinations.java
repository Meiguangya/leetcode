package main.java.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author meiguangya
 * @date 2026/1/4 下午5:06
 * @description 电话号码的字母组合
 * <p>
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
@Slf4j
public class BackTrackLetterCombinations {

    private static Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {

        List<String> list = map.get(String.valueOf(digits.charAt(0)));

        for (int i = 1; i < digits.length(); i++) {
            String num = String.valueOf(digits.charAt(i));

            List<String> numsLetter = map.get(num);

            list = combination(list, numsLetter);

        }

        return list;
    }

    private List<String> combination(List<String> target, List<String> list) {
        List<String> ret = new ArrayList<>();
        for (String s1 : target) {
            for (String s2 : list) {
                ret.add(s1 + s2);
            }
        }
        return ret;
    }


    // 上面是暴力法 遍历 添加

    // 使用回溯
    public List<String> letterCombinations2(String digits) {

        List<String> combinations = new ArrayList<>();

        backtrack(combinations,0,digits,new StringBuilder());

        return combinations;
    }

    public void backtrack(List<String> combinations, int index, String digits, StringBuilder combination) {

        if(index == digits.length()){
            combinations.add(combination.toString());
            return;
        }

        List<String> list = map.get(String.valueOf(digits.charAt(index)));
        for (String s : list) {
            combination.append(s);
            backtrack(combinations,index+1,digits,combination);
            combination.deleteCharAt(index);
        }

    }

    public static void main(String[] args) {

        BackTrackLetterCombinations b = new BackTrackLetterCombinations();

        List<String> list = b.letterCombinations2("32");

        log.info("list:[{}]",list);

    }

}
