package LeetCode2;

public class maxProfit {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        if (max < 0) {
            return 0;
        }else {
            return max;
        }
    }

    public int maxProfit2(int[] prices) {
        int max = Integer.MIN_VALUE;
        int mairu = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (mairu > prices[i]) {
                mairu = prices[i];
            }
            max = Math.max(max, prices[i] - mairu);
        }
        if (max < 0) {
            return 0;
        }else {
            return max;
        }
    }
}
