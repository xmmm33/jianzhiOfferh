package jianzhiOffer7;


/**
 * 构建乘积数组
 * 不能使用除法
 */
public class constructArr {


    /**
     * 思路 左乘 再 右乘
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a) {
        if (a == null || a.length < 1) {
            return new int[0];
        }
        int[] res = new int[a.length];
        int temp = 1;
        for (int i = 0; i < a.length; i++) {
            res[i] = temp;
            temp = temp * a[i];
        }
        temp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp = temp * a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        constructArr(new int[]{1, 2, 3, 4, 5});
    }
}
