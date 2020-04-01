package LeetCode1;


/**
 * 打家劫舍
 * 一维动归
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class rob {

    /**
     * 1 号房间可盗窃最大值为 3 即为 dp[1]=3，
     * 2 号房间可盗窃最大值为 4 即为 dp[2]=4，
     * 3 号房间自身的值为 2 即为 num=2，那么 dp[3] = MAX( dp[2], dp[1] + num ) = MAX(4, 3+2) = 5，3 号房间可盗窃最大值为5
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if(len < 1){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int max = Math.max(dp[0],dp[1]);
        for(int i =2;i<len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
