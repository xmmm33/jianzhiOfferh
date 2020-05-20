package jianzhiOffer5;


/**
 * 寻找0- n-1中缺失的数字
 */
public class missingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[nums.length-1] + 1;
    }
}
