package leetcode;

import java.util.HashMap;

public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i <s.length() ; i++) {
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
}
