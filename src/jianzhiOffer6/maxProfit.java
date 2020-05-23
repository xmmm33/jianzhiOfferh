package jianzhiOffer6;

/**
 * 股票的最大利润
 */
public class maxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            int in = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                maxprofit = Math.max(maxprofit, prices[j] - in);
            }
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        int res = 0;
        for (int num : prices) {
            cost = Math.min(cost,num);
            res = Math.max(res, num - cost);
        }
        return res;
    }
}
