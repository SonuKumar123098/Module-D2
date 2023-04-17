//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
class Solution
{
	public:
	//Function to find sum of weights of edges of the Minimum Spanning Tree.
    int spanningTree(int v, vector<vector<int>> adj[])
    {
        // code here
        vector<int>vis(v,0);
        //({wt,node})
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        int sum=0;
        pq.push({0,0});
        while(pq.size()){
            pair<int,int> p=pq.top();
            pq.pop();
            int node=p.second;
            int wt=p.first;
            if(vis[node])continue;
            vis[node]=1;
            sum+=wt;
            for(auto it:adj[node]){
                int w=it[1];
                int vert=it[0];
                if(!vis[vert]){
                    pq.push({w,vert});
                }
            }
        }
        return sum;
        
    }
};
