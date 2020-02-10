package day1.time_0209_2009;

/**
 * 旋转数组的最小数字
 * 把数组的开始元素移动到末尾称为数组的旋转
 * 输入一个非递减的数组的旋转
 */
public class Solution {

    public static int minNumberInRotateArray(int [] array) {
        int min = 0;
        if (array.length <= 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            int tmpmin = array[i];
            if (i == 0) {
                min = array[i];
            } else {
                if (min > tmpmin) {
                    min = tmpmin;
                }
            }
        }
        return min;
    }

    /**
     * 采用二分查找的升级版
     * 最小值一定比前面的小，后面的小。
     * @param array
     * @return
     */
    public static int binarySearch(int [] array) {
        int low = 0;
        int high = array.length - 1;
        if (array.length <= 0) {
            return 0;
        }
        // 如果array[high]的值比array[mid]的值大，说明最小值在左边
        // 如果array[high]的值比array[mid]的值小，说明最小值在右边
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            } else if (array[high] > array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335}));
    }
}
