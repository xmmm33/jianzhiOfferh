package jindian7;

public class search {

    // 搜索旋转数组
    public int search(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int search2(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int turn = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                turn = i;
                break;
            }
        }
        int reslow = Integer.MAX_VALUE;
        int reshi = Integer.MAX_VALUE;
        int left = 0;
        int right = turn == -1 ? arr.length - 1 : turn;
        int low = turn == -1 ? 0 : turn;
        int high = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }else {
                reslow = Math.min(mid,reslow);
                right--;
            }
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }else {
                reshi = Math.min(mid,reshi);
                high--;
            }
        }
        if (reshi == Integer.MAX_VALUE && reslow == Integer.MAX_VALUE) {
            return -1;
        }else {
            return Math.min(reshi, reslow);
        }
    }

}
