package jianzhiOffer2;

public class exchange {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int k = 0;
        while (left <= right) {
            if (nums[k] % 2 == 1) {
                res[left++] = nums[k];
            }else {
                res[right--] = nums[k];
            }
            k++;
        }
        return res;
    }
}
