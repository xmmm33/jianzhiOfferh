package jianzhiOffer5;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 找出只出现一次的字符
 */
public class firstUniqChar {

    public char firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return ' ';
        }
        if ("".equals(s)) {
            return ' ';
        }
        Map<Character, Integer> temp = new LinkedHashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i),0)+1);
        }
        for (Character key : temp.keySet()) {
            if (temp.get(key) == 1) {
                return key;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        if (s == null || s.length() < 1) {
            return ' ';
        }
        if ("".equals(s)) {
            return ' ';
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 判断字符首次出现的位置 是否等于字符最后一次出现的位置
            if (s.indexOf(ch) == i && s.indexOf(ch, i + 1) == -1) {
                return ch;
            }
        }
        return ' ';
    }
}
