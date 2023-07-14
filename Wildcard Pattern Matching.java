class Solution
{
    boolean f(int i, int j, String pattern, String str)
    {
        if(i<0) return true;
        if(j<0) return false;
        if(pattern.charAt(i)==str.charAt(j))
        {
            return f(i-1, j-1, pattern, str);
        }
        if(pattern.charAt(i)=='?')
        {
            return f(i-1, j-1, pattern, str);
        }
        if(pattern.charAt(i)=='*')
        {
            if(j>i) return f(i, j-1, pattern, str) 
                || f(i-1, j-1, pattern, str) 
                || f(i-1, j, pattern, str);
            return f(i-1, j-1, pattern, str);
        }
        return f(i, j-1, pattern, str);
    }
    int wildCard(String pattern, String str)
    {
        int n=pattern.length();
        int m=str.length();
        
        return f(n-1, m-1, pattern, str) == true ? 1 : 0;
    }
}
