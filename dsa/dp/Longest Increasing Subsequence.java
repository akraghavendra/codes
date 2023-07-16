class Solution 
{
    public static int f(int ind, int prev, int n, int[] a, int[][] dp)
    {
        if(ind==n) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int not_take=0+f(ind+1, prev, n, a, dp);
        int take=Integer.MIN_VALUE;
        if(prev==-1 || a[ind]>a[prev])
            take=1+f(ind+1, ind, n, a, dp);
        return dp[ind][prev+1]=Math.max(not_take, take);
        
    }
    static int longestSubsequence(int size, int a[])
    {
        int dp[][] = new int[size + 1][size + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(0, -1, size, a, dp);
    }
} 
