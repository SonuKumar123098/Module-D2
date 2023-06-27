//https://course.acciojob.com/idle?question=ea6b2dee-3908-4eda-b379-be147e6aef3e
import java.util.*;
class DSU{
	private int[]parent;
	private int[]size;
	public DSU(int n){
		parent=new int[n];
		size=new int[n];
		for(int i=0;i<n;i++){
			size[i]=1;
			parent[i]=i;
		}
	}
	int find(int x){
		if(parent[x]==x)return x;
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
			parent[b]=a;
			size[a]+=b;
		}
	}
}
class Edge implements Comparable<Edge>{
	int src;
	int dst;
	int wt;
	public Edge(int a,int b,int c){
		this.src=a;
		this.dst=b;
		this.wt=c;
	}
	public int compareTo(Edge e){
		return this.wt-e.wt;
	}
	public String toString(){
		return src+" "+dst+" "+wt;
	}
}
class Solution {
    List<Edge> edgeList;
    int V;

    public Solution(int V) {
        this.V = V;
        edgeList = new ArrayList<>();
    }

    public void addEdge(int x, int y, int w) {
        edgeList.add(new Edge(x, y, w));
    }

    public void kruskalsMST() {
       // Your code here
		Collections.sort(edgeList);
		// System.out.println(edgeList);
		DSU d=new DSU(V);
		int ans=0;
		for(int i=0;i<edgeList.size();i++){
		    Edge e=edgeList.get(i);
			int a=e.src;
			int b=e.dst;
			int wt=e.wt;
			a=d.find(a);
			b=d.find(b);
			if(a!=b){
				ans+=wt;
				d.union(a,b);
			}
		}
		System.out.println(ans);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Solution g = new Solution(v);
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            g.addEdge(src, dest, wt);
        }

        // Function call
        g.kruskalsMST();
    }
}
