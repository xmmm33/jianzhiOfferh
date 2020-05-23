package jianzhiOffer6;

public class constructArr {

    public static int[] constructArr(int[] a) {
        if (a == null || a.length < 1) {
            return new int[0];
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int tmp = 1;
            for (int j = 0; j <a.length ; j++) {
                if (i == j) {
                    continue;
                }
                tmp = tmp * a[j];
            }
            res[i] = tmp;
        }
        return res;
    }

    /**
     * 思路：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
     * @param a
     * @return
     */
    public static int[] constructArr2(int[] a) {
        if (a == null || a.length < 1) {
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        int tmp = 1;
        // 从右往左乘
        for (int i = 1; i < a.length; i++) {
            tmp *= a[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        // 从左往右乘
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        constructArr2(new int[]{1, 2, 3, 4, 5});
    }
}
