package day2.time_0301_1536;


/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {

    public int RectCover(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int k = 0;
        int ret = 0;
        int a = 1;
        int b = 2;
        while (k < target-2) {
            ret = a + b;
            a = b;
            b = ret;
            k++;
        }
        return ret;
    }

    public int RectCover2(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        return RectCover2(target - 1) + RectCover2(target - 2);
    }
}
