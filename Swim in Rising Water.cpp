// https://leetcode.com/problems/swim-in-rising-water/

class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        int n=grid.size(); int less=INT_MAX,high=INT_MIN;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                less=min(less,grid[i][j]);
                high=max(high,grid[i][j]);
            }
        }
        while(less<high){
            int mid=less+(high-less)/2;
            if(isPossible(grid,mid)){
                high=mid;
            }else less=mid+1;
        }
        return less;
    }
    private:
    int dirn[4][2]={{0,1},{0,-1},{1,0},{-1,0}};
    bool isPossible(vector<vector<int>>& grid, int mid){
        int n=grid.size();
        vector<vector<bool>>vis(n,vector<bool>(n,false));
        dfs(grid,n,mid,vis,0,0);
        return vis[n-1][n-1];
    }
    void dfs(vector<vector<int>>& grid,int &n,int& mid,vector<vector<bool>>&vis,int i,int j){
        if(!isValid(i,j,n,vis) || grid[i][j]>mid) return;
        
        if(vis[n-1][n-1]) return;
        vis[i][j]=true;
        for(int x=0;x<4;x++){
            dfs(grid,n,mid,vis,i+dirn[x][0],j+dirn[x][1]);
        }
    }
    bool isValid(int i,int j,int n,vector<vector<bool>>&vis){
        if(i<0 || j<0|| i>=n || j>=n || vis[i][j]) return false;
        return true;
    }
};


// https://course.acciojob.com/idle?question=fa40124d-8e14-4220-a4aa-1129803630fb
import java.util.*;
class Solution {
    public static int swimInWater(int[][] grid) {
        //Write your code here 
		int n=grid.length; int less=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                less=Math.min(less,grid[i][j]);
                high=Math.max(high,grid[i][j]);
            }
        }
        while(less<high){
            int mid=less+(high-less)/2;
            if(isPossible(grid,mid)){
                high=mid;
            }else less=mid+1;
        }
        return less;
    }
	static int dirn[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
   static boolean isValid(int i,int j,int n,boolean[][]vis){
        if(i<0 || j<0|| i>=n || j>=n || vis[i][j]) return false;
        return true;
    }
     static void dfs(int[][] grid,int n,int mid,boolean[][]vis,int i,int j){
        if(!isValid(i,j,n,vis) || grid[i][j]>mid) return;
        
        if(vis[n-1][n-1]) return;
        vis[i][j]=true;
        for(int x=0;x<4;x++){
            dfs(grid,n,mid,vis,i+dirn[x][0],j+dirn[x][1]);
        }
    }
static boolean isPossible(int[][] grid, int mid){
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        dfs(grid,n,mid,vis,0,0);
        return vis[n-1][n-1];
    }
    
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ; 
        int[][] grid = new int[n][n];
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(Solution.swimInWater(grid));
    }
}
