//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
class Solution {
    private static void dfs(ArrayList<Integer>[]adj,HashSet<Integer> visited,int node){
		visited.add(node);
		for(int x:adj[node]){
			if(!visited.contains(x))
				dfs(adj,visited,x);
		}
	}
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<edges.length;i++){
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}
		HashSet<Integer> visited=new HashSet<>();
		long ans=0; long visitedNode=0;
		for(int i=0;i<n;i++){
			if(!visited.contains(i)){
				dfs(adj,visited,i);
				long nodeVisit=visited.size()-visitedNode;
				ans+=(visitedNode*nodeVisit);
				visitedNode=visited.size();
			}
		}
		return ans;
    }
}
