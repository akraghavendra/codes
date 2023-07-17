// recursion
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


// tabulation regular
    static int longestSubsequence(int size, int a[])
    {
        int dp[][] = new int[size + 1][size + 1];
        
        for (int row[] : dp)
            Arrays.fill(row, 0);
            
        // bases cases taken care : 0
        for(int ind=size-1;ind>=0;ind--)
        {
            for(int prev=ind-1;prev>=-1;prev--)
            {
                int not_take=0+dp[ind+1][prev+1];
                int take=Integer.MIN_VALUE;
                if(prev==-1 || a[ind]>a[prev])
                    take=1+dp[ind+1][ind+1];
                dp[ind][prev+1]=Math.max(not_take, take);
            }
        }
        return dp[0][0];
    }

// tabulation special
class Solution 
{
    static int longestSubsequence(int size, int a[])
    {
        int dp[] = new int[size];
        
        // special tabulation
        Arrays.fill(dp, 1);
        
        int max=0;
        for(int ind=0;ind<size;ind++)
        {
            for(int prev=0;prev<ind;prev++)
            {
                if(a[ind]>a[prev] && dp[prev]+1>dp[ind])
                {
                    dp[ind]=dp[prev]+1;
                }
            }
            max=Math.max(max, dp[ind]);
        }
        return max;
    }
} 

