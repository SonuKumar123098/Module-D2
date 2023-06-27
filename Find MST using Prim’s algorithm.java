//https://course.acciojob.com/idle?question=8ad1e55f-20df-48de-b7a9-941fa4c1b0c6
import java.util.*;
class Solution{
	static int findKey(int key[],boolean mst[]){
		int col=-1; int val=Integer.MAX_VALUE;
		int n=key.length;
			for(int j=0;j<n;j++){
				if(!mst[j]){
					if(key[j]<val){
						col=j;
						val=key[j];
						// parent[j]=i;
						// i=j;
					}
				}
			}
		return col;
	}
    static void primMST(List<List<Integer>> graph) {
        // Your code here
		int n=graph.size();
		boolean[]mst=new boolean[n];
		int parent[]=new int[n];
		int[]key=new int[n];
		Arrays.fill(key,Integer.MAX_VALUE);
		key[0]=0;
		// mst[0]=true;
		// PriorityQueue<Integer>pq=new PriorityQueue<>();
		int ans=0;
		int col=findKey(key,mst);
		int pre=-1;
		while(col!=-1){
			mst[col]=true;
			parent[col]=pre;
			ans+=key[col];
			for(int j=0;j<n;j++){
				if(graph.get(col).get(j)!=0 && !mst[j]){
					if(key[j]>graph.get(col).get(j)){
						key[j]=graph.get(col).get(j);
					}
				}
			}
			col=findKey(key,mst);
		}
		System.out.println(ans);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> temp = new ArrayList<>(V);
            for (int j = 0; j < V; j++) {
                temp.add(sc.nextInt());
            }
            graph.add(temp);
        }
        Solution.primMST(graph);
        sc.close();
    }
}
