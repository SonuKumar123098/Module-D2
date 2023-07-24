// https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
class TreeAncestor {
    int depth[];//depth of every node
    int dfn[];//dfs number of every node
    int ndfn;//dfs number
    List<List<Integer>>level;//level of every node
    List<Integer>tree[];
    public TreeAncestor(int n, int[] parent) {
        depth=new int[n];
        level=new ArrayList<>();
        dfn=new int[n];
        ndfn=0;//dfs number for root number is zero
        tree=new List[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            tree[parent[i]].add(i);
        }
        dfs(0,0);//depth is  zero for parent node 0
    }
    private void dfs(int n,int dep){
        if(level.size()==dep){
            level.add(new ArrayList<>());
        }
        depth[n]=dep;
        dfn[n]=ndfn++;//store dfs number for
        level.get(dep).add(n);//store  level of node n
        for(int child:tree[n]){
            dfs(child,dep+1);//increase depth for child is parent depth+1
        }
    }
    public int getKthAncestor(int node, int k) {
        int d=depth[node];
        if(d<k)return -1;
        List<Integer>list=level.get(d-k);
        return search(list,dfn[node]);
    }
    private int search(List<Integer>list,int number){
        int low=0;
        int high=list.size()-1;
        while(low<high){
            int mid=low+(high-low+1)/2;
            if(dfn[list.get(mid)]>=number){
                high=mid-1;
            }else low=mid;
        }
        return list.get(low);
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

// https://course.acciojob.com/idle?question=775f2cc3-6262-45bf-b2ba-a92d983b4b01
import java.util.*;

class Solution {
      public int kthAncestor(int n, int[] parent, int node, int k) {
        //write code here
		  int cnt=k;
		  int ancestor=node;
		  while(cnt-->0){
			  if(parent[ancestor]!=-1){
				  ancestor=parent[ancestor];
			  }else break;
		  }
		  if(cnt<0) return ancestor;
		  return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int parent[] = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = sc.nextInt();
        int node = sc.nextInt();
        int k = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.kthAncestor(n, parent, node, k));
        sc.close();
    }
}
