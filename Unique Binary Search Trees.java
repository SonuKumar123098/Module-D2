// https://leetcode.com/problems/unique-binary-search-trees/description/
// https://course.acciojob.com/idle?question=7629ffcc-28a9-4576-a920-6e5f52991a52
import java.util.*;
class Solution{
    static int dp[];
    public static long numTrees(int n) {
        //write your code here
        dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		return solve(n);
    }
	private static int solve(int n){
		if(dp[n]!=0) return dp[n];
		int ans=0;
		for(int i=1;i<=n;i++){
			ans+=solve(i-1)*solve(n-i);
		}
		return dp[n]=ans;
	}
}
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Solution.numTrees(n));
    }
}
