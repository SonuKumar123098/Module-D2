//https://leetcode.com/problems/redundant-connection/description/
//https://course.acciojob.com/idle?question=504c7464-d786-42b5-8807-4ff8e3b64918
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU d=new DSU(n);
        int x=0,y=0;
        for(int i=0;i<n;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            a=d.find(a);
            b=d.find(b);
            if(a!=b){
                d.union(a,b);
            }
            else{
                x=edges[i][0];
                y=edges[i][1];
            }
        }
        return new int[]{x,y};
    }
}
class DSU{
    private int[]parent;
    private int[]size;
    public DSU(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]<size[b]){
                int temp=a;
                a=b;
                b=temp;
            }
            size[a]+=size[b];
            parent[b]=a;
        }
    }
}
