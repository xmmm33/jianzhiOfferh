package day1.time_0212_1347;

import java.util.*;

/**
 * 孩子们的游戏
 * 小朋友围成一个圈 length = n
 * 随机指定一个数m，m <= n
 * 每次报数到m-1的孩子出列，并且不再回圈中，从新开始从0开始报数
 * 找出最后剩下的那位小朋友
 *
 * 还是找通项 f(n) = (f(n-1) + m) % n
 */
public class LastRemaining_Solution {

    /**
     * 孩子们的游戏1
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int v = 0;
        int cur = 0;
        for (int i = 2; i <n+1 ; i++) {
            cur = (v + m) % i;
            v = cur;
        }
        return v;
    }
    /**
     * 孩子们的游戏2
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_SolutionTwo(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(i);
        }

        int  cur =0;
        while (temp.size() > 1) {
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur > temp.size()) {
                    cur=0;
                }
            }
            temp.remove(cur);
            cur--;
        }
        return temp.get(0);
    }

    /**
     * 糖果游戏
     * 比如 1 1 2
     * 最少有5名同学拿到了糖果
     * 思路：先把这些数字put到map中，
     * 然后遍历map，取出这些key出现的次数，然后根据次数分组
     * 比如key为1出现了3次，那么此时最少的人数为11 1=2 + 2等于4个人，也就是 3/i+1向上取整 * i+1 = [3/2] * 2 = 4;
     */
    public int leastCandy(int[] array) {
        Map<Integer, Integer> temp = new HashMap<>();
        int cout = 0;
        for (int i : array) {
            if (temp.containsKey(i)) {
                temp.put(i, temp.get(i) + 1);
            }else {
                temp.put(i, 1);
            }
        }
        for (Integer i : temp.keySet()) {
            if (temp.get(i) > i + 1) {
                int a = (int) (Math.ceil((double) temp.get(i) / (double) (i + 1)) * (i + 1));
                cout = cout + a;
            }else {
                cout = cout + i+1;
            }
        }
        return cout;
    }
}
