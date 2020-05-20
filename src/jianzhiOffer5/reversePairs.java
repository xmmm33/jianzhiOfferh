package jianzhiOffer5;

/**
 * 寻找数组中的逆序对的个数
 */
public class reversePairs {

    /**
     * 暴力搜索
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res  = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
