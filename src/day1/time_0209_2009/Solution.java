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

    /**
     * 二分法版本2
     * @param array
     * @return
     */
    public static int binarySearchTwo(int [] array) {
        int low = 0;
        int high = array.length - 1;
        if (array.length <= 0) {
            return 0;
        }
        // 用mid的值分别减去左右两边的值
        // 往绝对值大的一边偏
        while (low <= high) {
            int mid = (low + high) >> 1;
            if(Math.abs(array[mid] - array[high]) > Math.abs(array[mid] - array[low])){
                low = mid + 1;
            } else if (Math.abs(array[mid] - array[high]) < Math.abs(array[mid] - array[low])) {
                high = mid - 1;
            } else {
                return array[mid];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{3,4,5,1,2}));
    }
}