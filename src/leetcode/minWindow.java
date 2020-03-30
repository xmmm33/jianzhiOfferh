package leetcode;

import java.util.HashMap;
import java.util.Map;

public class minWindow {

    /**
     * 滑动窗口
     * 在s中寻找最小字串res，包含字符串t
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() < 1 || t.length() < 1) {
            return "";
        }
        // 使用map来记录s子串中匹配对应t字符的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // 初始化s的字符，全部为key-0
            map.put(c, 0);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String res = "";
        int cnt = t.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 将字符进行匹配；判断字串中是否包含t字符串
            if (map.get(c) > 0) {
                cnt--;
            }
            map.put(c, map.get(c) - 1);
            right++;
            while (cnt == 0) {
                // 替换最小结果
                if (res.length() == 0) {
                    res = s.substring(left, right);
                } else if ((res.length() > (right - left))) {
                    res = s.substring(left, right);
                }
                // 移动左指针
                char c1 = s.charAt(left);
                // 判断是否是t中的字符
                if (map.get(c1) == 0) {
                    cnt++;
                }
                map.put(c1, map.get(c1) + 1);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}
