//https://leetcode.com/problems/path-with-minimum-effort/
class Solution {
public:
        
        int vis[100][100];
       vector<pair<int,int>>dir={{0,1},{0,-1},{1,0},{-1,0}};
        void ok(int x,int y,int& mid,vector<vector<int>>&h)
        {
                if(!vis[x][y])
                {
                        vis[x][y]=1;
                         int m=h.size();
                         int n=h[0].size();
                        for(int i=0;i<4;i++)
                        {
                                int x1=x+dir[i].first;
                                int y1=y+dir[i].second;
                                if(x1<0||y1<0||x1>=m||y1>=n)
                                {
                                        continue;
                                }
                                if(abs(h[x][y]-h[x1][y1])<=mid)
                                {
                                        ok(x1,y1,mid,h);
                                }
                        }
                }

        }
    int minimumEffortPath(vector<vector<int>>& h) {
        int l=0;int r=1e6;
            int m=h.size();
            int n=h[0].size();
            while(l<r)
            {
                    int mid=l+(r-l)/2;
                    memset(vis,0,sizeof(vis));
                    ok(0,0,mid,h);
                    if(vis[m-1][n-1]==1){
                            r=mid;                           
                    }
                    else l=mid+1;
            }
            return l;
    }
};
