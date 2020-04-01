package LeetCode1;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i <s.length() ; i++) {
            // 如果出现重复字符的时候，就计算一次left指针
            if (map.containsKey(s.charAt(i))) {
                // 这里去max是为了 abba---当遍历到最后的a时，防止left变为1；
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            // key为字符；value为字符出现过的位置
            map.put(s.charAt(i), i);
            max = Math.max(i-left+1,max);
        }
        return max;
    }

    public int lengthsub(String s) {
        if (s.length() < 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果出现重复字符，就更新左指针，
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
