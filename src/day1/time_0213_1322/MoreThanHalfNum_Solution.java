package day1.time_0213_1322;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到在数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum_Solution {

    /**
     * 解决办法1
     * 时间复杂度和空间复杂度都是O(n)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> res = new HashMap<>();
        int level = array.length / 2;
        for (int i : array) {
            if (res.containsKey(i)) {
                res.put(i, res.get(i) + 1);
            }else {
                res.put(i, 1);
            }
        }
        for (Integer i : res.keySet()) {
            if (res.get(i) > level) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 解决办法2
     * 空间复杂度是O(1)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_SolutionTwo(int [] array) {
        int n = 0;
        int ret = 0;
        // 这个循环找到可能是的那个值
        for (int i = 0; i <array.length ; i++) {
            if (n == 0) {
                ret = array[i];
                n++;
            }else {
                if (ret == array[i]) {
                    n++;
                } else {
                    n--;
                }
            }
        }
        int cout = 0;
        // 这个循环判断是不是真的是
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == ret) {
                cout++;
            }
            if (cout > array.length / 2) {
                return ret;
            }
        }
        return 0;
    }
}
