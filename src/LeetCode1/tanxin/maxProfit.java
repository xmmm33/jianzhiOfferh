package LeetCode1.tanxin;

/**
 * 寻找最大的股票收益日期
 */
public class maxProfit {

    public static int maxProfit(int[] prices) {
        int maxP = 0;
        int low = Integer.MAX_VALUE;
        // low记录最小股票值，然后与每天的股票价格做查，取最大值
        for(int p : prices) {
            if(p < low) {
                low = p;
            }
            maxP = Math.max(maxP, p - low);
        }
        return maxP;
    }

    public static void main(String[] atgs) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
