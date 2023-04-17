//https://leetcode.com/problems/min-cost-to-connect-all-points/description/
//c++ code
//prims algorithms
class Solution {
public://prim's algoriithms;
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n=points.size();  int res=0;
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>pq;
        vector<bool>visited(n,false);
       pq.push({0,0});
       while(pq.size()){
           pair<int,int>topPoint=pq.top();
           pq.pop();
           int node=topPoint.second;
           int wt=topPoint.first;
           if(visited[node])continue;
           visited[node]=true;
           res+=wt;
           for(int i=0;i<n;i++){
               if(!visited[i]){
                    pq.push({abs(points[node][0]-points[i][0])+abs(points[node][1]-points[i][1]),i});
               }
           }
       }
       return res;
    }
};
//java code
class Pair{
  int wt;
  int node;
  Pair(int a, int b){
      this.wt=a;
      this.node=b;
    } 
}
class sortByWeight implements Comparator<Pair>{
     public int compare(Pair a, Pair b){
          return a.wt-b.wt;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair>pq=new PriorityQueue<>(new sortByWeight());
        int n=points.length;
        boolean []visited=new boolean[n];
        int i=0; int res=0; int connected=0;
        while(++connected<n){
            visited[i]=true;
            for(int j=0;j<n;j++){
                if(!visited[j]){
                    pq.add(new Pair(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]), j ));
                }
            }
            while(visited[pq.peek().node]) pq.remove();
            i=pq.peek().node;
            res+=pq.peek().wt;
            pq.remove();
        }
        return res;
    }
}
