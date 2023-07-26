// https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
// https://course.acciojob.com/idle?question=67547211-a7d6-47ad-b578-32ece0d9808b



//User function Template for Java

class Solution
{
    static int[][]dp;
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        dp=new int[m+1][n+1];
        return solve(X,Y,m,n,0,0);
    }
    private static int solve(String x,String y,int m,int n,int i,int j){
        if(i==m && j==n)return 0;
        int ans=Integer.MAX_VALUE;
        if(dp[i][j]!=0)return dp[i][j];
        if( i<m && j<n && x.charAt(i)==y.charAt(j)){
            ans=1+solve(x,y,m,n,i+1,j+1);
        }else{
            if(i<m){
                ans=Math.min(ans,1+solve(x,y,m,n,i+1,j));
            }
            if(j<n)
            ans=Math.min(ans,1+solve(x,y,m,n,i,j+1));
        }
        return dp[i][j]=ans;
    }
}
