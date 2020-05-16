package jianzhiOffer4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 最长不重复字串长度
 */
public class lengthOfLongestSubstring {

    /**
     * 优化的滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        Map<Character, Integer> temp = new HashMap<>();
        while (right < s.length()) {
            if (temp.containsKey(s.charAt(right))) {
                left = Math.max(left, temp.get(s.charAt(right))+1);
            }
            temp.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    /**
     * 原生的滑动窗口算法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        HashSet<Character> temp = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            while (temp.contains(c)) {
                temp.remove(c);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
