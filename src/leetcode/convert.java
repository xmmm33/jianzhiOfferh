package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 之字形
 * flag = - flag： 在达到 Z 字形转折点时，执行反向。
 */
public class convert {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = 0-flag;
            }
            i = i + flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : rows) {
            res.append(temp);
        }
        return res.toString();
    }
}
