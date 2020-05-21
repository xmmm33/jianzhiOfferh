package jianzhiOffer6;


import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正整数序列
 */
public class findContinuousSequence {


    /**
     * 暴力法
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        int bound = 0;
        if (target % 2 == 1) {
            bound = target / 2 + 1;
        }else {
            bound = target / 2;
        }
        List<int[]> temp = new ArrayList<>();
        for (int i = 1; i <= bound; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int j = i; j <=bound && sum < target ; j++) {
                list.add(j);
                sum += j;
            }
            if (sum == target) {
                int[] r = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    r[j] = list.get(j);
                }
                temp.add(r);
            }
        }
        /*int[][] res = new int[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;*/
        return temp.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        findContinuousSequence2(15);
    }

    /**
     * 滑动窗口
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence2(int target) {
        int low = 1;
        int high = 2;
        List<int[]> temp = new ArrayList<>();
        int sum = 0;
        while (low <= target / 2) {
            // 等差数列求和
            sum = (low + high) * (high - low + 1) / 2;
            if (sum > target) {
                low++;
            } else if (sum < target) {
                high++;
            }else {
                int t = 0;
                int[] tempres = new int[high - low + 1];
                for (int i = low; i <= high; i++) {
                    tempres[t++] = i;
                }
                temp.add(tempres);
                low++;
            }
        }
        return temp.toArray(new int[0][]);
    }
}
