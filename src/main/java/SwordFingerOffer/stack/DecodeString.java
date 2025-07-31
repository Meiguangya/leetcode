package main.java.SwordFingerOffer.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author meiguangya
 * @date 2025/7/31 下午7:19
 * @description 字符串解码
 *   3[a2[c]] => accaccacc
 */
@Slf4j
public class DecodeString {

    // 3[a2[c]]
    public String decodeString(String s) {

        LinkedList<Integer> multiList = new LinkedList<>();
        LinkedList<String> retList = new LinkedList<>();
        StringBuilder ret = new StringBuilder("");
        int multi = 0;

        char[] charArray = s.toCharArray();
        for (char c : charArray) {

            if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
                continue;
            }

            if (c == '[') {
                multiList.add(multi);
                retList.add(ret.toString());
                ret = new StringBuilder("");
                multi = 0;
                continue;
            }

            if ('a' <= c && c <= 'z') {
                ret.append(c);
                continue;
            }

            if (c == ']') {
                StringBuilder temp = new StringBuilder("");
                Integer count = multiList.removeLast();
                for (int j = 0; j < count; j++) {
                    temp.append(ret);
                }

                ret = new StringBuilder(retList.removeLast()).append(temp);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {

        DecodeString demo = new DecodeString();

        String s = "10[abc]";

        String ret = demo.decodeString(s);
        log.info("ret:{}", ret);

    }


}
