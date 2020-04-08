package LeetCode4;

import java.util.*;

public class findAnagrams {


    /**
     * 暴力法
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return res;
        }
        char[] ps = p.toCharArray();
        Arrays.sort(ps);
        String sortedp = new String(ps);
        int size = ps.length;
        int start = 0;
        while (size <= s.length()) {
            char[] temp = s.substring(start, size).toCharArray();
            Arrays.sort(temp);
            if (sortedp.equals(new String(temp))) {
                res.add(start);
            }
            start++;
            size++;
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams2("cbaebabacd", "abc");
    }


    /**
     * 滑动窗口法
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < 1) {
            return res;
        }
        // 记录p中每个字符出现的次数
        Map<Character, Integer> pmap = new HashMap<>();
        for (char i : p.toCharArray()) {
            pmap.put(i, pmap.getOrDefault(i, 0) + 1);
        }
        // 滑动窗口map
        Map<Character, Integer> window = new HashMap<>();
        for (char i : s.toCharArray()) {
            window.put(i, 0);
        }
        int left = 0;
        int right = 0;
        int valid = p.length();
        while (right < s.length()) {
            if (pmap.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                // 如果窗口中出现一个p中的有效字符，那么valid就要减一了
                if (window.get(s.charAt(right)) <= pmap.get(s.charAt(right))) {
                    valid--;
                }
            }
            while (valid == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                // 这个时候需要移动左指针了
                // 如果left指向的是p中的有效字符，那么对应的window中需要对计数减一操作
                if (pmap.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left))-1);
                    // 这个if如果为真，就说明现有的窗口已经不合符匹配条件了
                    // 需要移动左指针和右指针
                    if (window.get(s.charAt(left)) < pmap.get(s.charAt(left))) {
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
