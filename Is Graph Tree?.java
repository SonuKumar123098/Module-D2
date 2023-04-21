//https://course.acciojob.com/idle?question=f10e32c0-3a7f-450c-a074-541fc8e7540f
class Solution 
{
	static boolean isNotTree(ArrayList<Integer>adj[],int node,boolean visited[],int parent){
		visited[node]=true;
		for(int x:adj[node]){
			if(!visited[x]){
				if(isNotTree(adj,x,visited,node)) return true;
			}else if(visited[x] && x!=parent) return true;
			else{
				//check for parallel edge
				int cnt=0;
				for(int child:adj[node]){
					if(child==parent)cnt++;
				}
				if(cnt>1) return true;
			}
		}
		return false;
	}
    static boolean isGraphTree(int n, ArrayList<ArrayList<Integer>> edgeList) 
    {
       ArrayList<Integer>adj[]=new ArrayList[n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<>();
		}
		for(var i:edgeList){
			adj[i.get(0)].add(i.get(1));
			adj[i.get(1)].add(i.get(0));
		}
		boolean visited[]=new boolean[n];
		for(int i=0;i<n;i++){
			if(!visited[i]){
				if(isNotTree(adj,i,visited,-1)) return false;
			}
		}
		return true;
    }
}
