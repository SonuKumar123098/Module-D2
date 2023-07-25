// https://course.acciojob.com/idle?question=74a8eec8-e108-4a93-8907-fda51e1e97f2
// https://leetcode.com/problems/coin-change/description/
#include <bits/stdc++.h>
using namespace std;

class Solution
{

public:
    vector<vector<int>>dp;
    int minCoins(int coins[], int M, int V)
    {
        // Your code goes here
		dp=vector<vector<int>>(M,vector<int>(V+1,-1));
        int ans=solve(coins,M,V,0);
		return ans<INT_MAX-1?ans:-1;
    }
     int solve(int coins[],int n,int amount,int index){
		 if(index>=n || amount==0){
			 return (amount==0)?0:INT_MAX-1;
		 }
		 int res=INT_MAX;
		 if(dp[index][amount]!=-1)return dp[index][amount];
		 if(amount>=coins[index]){
			  res=1+solve(coins,n,amount-coins[index],index);
		 }
		 int notCoinTake=solve(coins,n,amount,index+1);
		 return dp[index][amount]=min(res,notCoinTake);
	 }
};

int main()
{

    int v, m;
    cin >> v >> m;

    int coins[m];
    for (int i = 0; i < m; i++)
        cin >> coins[i];

    Solution ob;
    cout << ob.minCoins(coins, m, v) << "\n";

    return 0;
}
