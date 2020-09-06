package jindian6;


public class quick {

    public static void quicksort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        quicks(nums, 0, nums.length - 1);
        System.out.println(111);
    }

    private static void quicks(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int base = nums[low];
        int l = low;
        int r = high;
        while (l < r) {
            while (l < r && base <= nums[r]) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && base >= nums[l]) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = base;
        quicks(nums, low, l - 1);
        quicks(nums, l + 1, high);
    }
}
