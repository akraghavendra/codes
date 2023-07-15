public class Solution {
 public static long f(int ind, int buyflag, int n, long[] prices)
    {
        if(ind==n)
            return 0;
        long profit=0;
        if(buyflag==1)
        {
            long buy     = (-1)*prices[ind] + f(ind+1, 0, n, prices);
            long notbuy  = 0                + f(ind+1, 1, n, prices);
            profit = Math.max(buy, notbuy);
        }
        else
        {
            long sell    = prices[ind]   + f(ind+1, 1, n, prices);
            long notsell = 0             + f(ind+1, 0, n, prices);
            profit = Math.max(sell, notsell);
        }
        
        return profit;
    }
    public static long getMaximumProfit(int n, long[] values) {
        return f(0, 0, n, values);
    }

}
