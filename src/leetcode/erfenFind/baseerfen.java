package leetcode.erfenFind;

/**
 * 常规的二分查找
 * 时间复杂度logN
 */
public class baseerfen {

    public static int erfen(int[] array,int target) {
        if (array.length < 1) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            // 这种计算mid的方式可能会出现加法溢出
//            int mid = (left + right) / 2;
            // 所以采用这种方式
            int mid = left + (right - left) / 2;
            if (target > array[mid]) {
                left = mid + 1;
            } else if (target < array[mid]) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] a) {
        System.out.println(erfen(new int[]{1, 2, 3, 4, 5, 6, 7,8}, 5));
    }
}
