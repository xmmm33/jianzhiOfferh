package jindian6;

public class merge {

    // 合并排序的数组
    public static void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        int k = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[k--] = A[a--];
            }else {
                A[k--] = B[b--];
            }
        }
        while (b >= 0) {
            A[k--] = B[b--];
        }
    }


    public static void guibing(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        guibingsort(nums, 0, nums.length - 1);
        System.out.println(111);
    }

    private static void guibingsort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        guibingsort(nums, low, mid);
        guibingsort(nums, mid + 1, high);
        mergettt(nums, low, mid, high);
    }

    private static void mergettt(int[] nums, int low, int mid, int high) {
        int l = low;
        int r = mid + 1;
        int[] fuzhu = new int[nums.length];
        int k = low;
        while (l <= mid && r <= high) {
            if (nums[l] < nums[r]) {
                fuzhu[k++] = nums[l++];
            }else {
                fuzhu[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            fuzhu[k++] = nums[l++];
        }
        while (r <= high) {
            fuzhu[k++] = nums[r++];
        }
        for (int i = low; i <= high; i++) {
            nums[i] = fuzhu[i];
        }
    }


    public static void main(String[] args) {
//        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        guibing(new int[]{1, 8, 8, 6, 4, 1, 3});
    }

}
