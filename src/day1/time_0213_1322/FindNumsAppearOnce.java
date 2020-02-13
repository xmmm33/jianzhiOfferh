package day1.time_0213_1322;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中只出现1次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i : array) {
            if (res.containsKey(i)) {
                res.put(i, res.get(i) + 1);
            }else {
                res.put(i, 1);
            }
        }
        int a = 0;
        int b = 0;
        for (Map.Entry<Integer, Integer> temp : res.entrySet()) {
            if (temp.getValue() == 1) {
                if (a <= 0) {
                    num1[a++] = temp.getKey();
                }else {
                    num2[b++] = temp.getKey();
                }
            }
            if (a > 0 && b > 0) {
                break;
            }
        }
    }

    /**
     * 使用异或操作
     * 两个相同的数字，异或的结果为0
     * 两个不相同的数字，异或的结果不为0
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnceTwo(int [] array,int num1[] , int num2[]) {
        int a = 0;
        int b = 0;
        for (int i = 0; i <array.length ; i++) {
            boolean same = false;
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                }else {
                    int t = array[i] ^ array[j];
                    if (t == 0) {
                        same = true;
                        break;
                    }
                }
            }
            if (!same) {
                if (a <= 0)num1[a++] = array[i];
                else num2[b++] = array[i];
            }
            if (a > 0 && b > 0) {
                break;
            }
        }
    }
}
