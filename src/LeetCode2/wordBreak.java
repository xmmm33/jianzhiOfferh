package LeetCode2;

import java.util.List;

public class wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() < 1) {
            return false;
        }
        for (String temp : wordDict) {
            if (s.contains(temp)) {
                s = s.replaceAll(temp, "");
            }
        }
        if (s.equals("")) {
            return true;
        }else {
            return false;
        }
    }
}
