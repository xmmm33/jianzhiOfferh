package jindian;

import java.util.HashSet;
import java.util.Set;

public class canPermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Set<Character> temp = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (temp.contains(c)) {
                temp.remove(c);
            }else{
                temp.add(c);
            }
        }
        return temp.size() <= 1;
    }
}
