// https://course.acciojob.com/idle?question=07f64edb-63a1-49c7-9929-042ad7eda233
// https://practice.geeksforgeeks.org/problems/longest-possible-route-in-a-matrix-with-hurdles/1


class Solution {
    static int ans;
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        // code here
        ans=-1;
        if(mat[xs][ys]==0) return ans;
        boolean visited[][]=new boolean[n][m];
        solve(mat,xs,ys,xd,yd,visited,0);
        return ans;
    }
    static int dirn[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private static boolean isValidIndex(int[][]mat,int m,int n,int x,int y){
        if(x<0||x>=m||y<0||y>=n||mat[x][y]==0) return false;
        return true;
    }
    private static void solve(int mat[][],int i,int j,int x,int y,boolean visited[][],int dist){
        if(i==x && y==j){
          ans=Math.max(ans,dist);
          return;
        }
        visited[i][j]=true;
        int val=0;
        for(int d=0;d<4;d++){
            int row=i+dirn[d][0];
            int col=j+dirn[d][1];
            if(isValidIndex(mat,mat.length,mat[0].length,row,col)){
                if(!visited[row][col]){
                    solve(mat,row,col,x,y,visited,dist+1);
                }
            }
        }
        // ans=Math.max(ans,val);
        visited[i][j]=false;
    }
}
        
