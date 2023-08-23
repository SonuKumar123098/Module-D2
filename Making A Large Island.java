// https://leetcode.com/problems/making-a-large-island/description/
// https://course.acciojob.com/idle?question=ce10f57c-c553-461f-a3e2-be9e5581d44b
class Solution {
    boolean visited[][];
    int[][]dirn=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        visited=new boolean[n][n];
        DSU dsu=new DSU(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    dfs(grid,i,j,dsu);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n*n;i++){
            ans=Math.max(ans,dsu.getSize(i));
        }
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int val=1;
                    for(int d=0;d<4;d++){
                        int x=dirn[d][0]+i;
                        int y=dirn[d][1]+j;
                        if(isValid(x,y,grid)){
                            int a=dsu.find(x*n+y);
                            if(!hs.contains(a))
                            val+=dsu.getSize(a);
                            hs.add(a);
                        }
                    }
                    hs.clear();
                    ans=Math.max(ans,val);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid,int i,int j,DSU dsu){
        visited[i][j]=true;
        int n=grid.length;
        for(int d=0;d<4;d++){
            int x=dirn[d][0]+i;
            int y=dirn[d][1]+j;
            if(isValid(x,y,grid) && !visited[x][y]){
                if(dsu.find(i*n+j)!=dsu.find(x*n+y)){
                    dsu.union(i*n+j,x*n+y);
                }
                dfs(grid,x,y,dsu);
            }
        }
    }
    private boolean isValid(int i,int j,int [][]grid){
        int n=grid.length;
        if(i<0 || j<0 || i>=n || j>=n  || grid[i][j]==0)return false;
        return true;
    }
}
class DSU{
   private int[] parent;
   private int[]size;
    public DSU(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            // assume size of b is lesser than size of a
            if(size[a]<size[b]){
                //swap both value
                int temp=a;
                a=b;
                b=temp;
            }
            parent[b]=a;
            size[a]+=size[b];
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    public int getSize(int k){
        return size[k];
    }
}
// 2nd approach
class Solution {
    int groups[][];
    int[][]dirn=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        groups=new int[n][n];
        HashMap<Integer,Integer>group=new HashMap<>();
        int groupNo=1;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && groups[i][j]==0){
                    int area=dfs(grid,i,j,groupNo);
                    group.put(groupNo,area);
                    groupNo++;
                    ans=Math.max(ans,area);
                }
            }
        }
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int val=1;
                    for(int d=0;d<4;d++){
                        int x=dirn[d][0]+i;
                        int y=dirn[d][1]+j;
                        if(isValid(x,y,grid)){
                            int a=groups[x][y];
                            if(!hs.contains(a))
                            val+=group.get(a);
                            hs.add(a);
                        }
                    }
                    hs.clear();
                    ans=Math.max(ans,val);
                }
            }
        }
        return ans;
    }
    private int dfs(int[][] grid,int i,int j,int groupNo){
        groups[i][j]=groupNo;
        int n=grid.length;
        int cnt=1;
        for(int d=0;d<4;d++){
            int x=dirn[d][0]+i;
            int y=dirn[d][1]+j;
            if(isValid(x,y,grid) && groups[x][y]==0){
               cnt+= dfs(grid,x,y,groupNo);
            }
        }
        return cnt;
    }
    private boolean isValid(int i,int j,int [][]grid){
        int n=grid.length;
        if(i<0 || j<0 || i>=n || j>=n  || grid[i][j]==0)return false;
        return true;
    }
}
