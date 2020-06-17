package jindian7;

import java.util.*;

public class groupAnagrams {

    /**
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> temp = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (temp.containsKey(key)) {
                temp.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                temp.put(key,list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : temp.keySet()) {
            res.add(temp.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
