//https://course.acciojob.com/idle?question=4c584a57-aac9-46d6-b075-b69edb00eb15
//prims algorithms
import java.util.*;
class pair{
	int node;
	int wt;
	int parent;
	public pair(int a ,int b,int p){
		this.node=a;
		this.wt=b;
		this.parent=p;
	}
}
class Solution {
    static int findcost(int n, int city[][]) {
        //Write your code here
		return prims(city,n);
    }
 private static int prims(int[][]city,int n){
	 // int key[]=new int[n];//it needs when we do not use priority queue,therefore 
	 //here no use of this
	 // int max=
	 int totalcost=0;
	 // Arrays.fill(key,max);
	 int[]parent=new int[n];
	 Arrays.fill(parent,-1);
	 boolean mst[]=new boolean[n];
	 // mst[0]=true;
	 PriorityQueue<pair>pq=new PriorityQueue<>(new Comparator<pair>(){
		 public int compare(pair a,pair b){
			 return a.wt-b.wt;
			 
		 }
	 });
	 pq.add(new pair(0,0,-1));
	 while(!pq.isEmpty()){
		 pair p=pq.remove();
		 int v=p.node;
		 int cost=p.wt;
		 // System.out .println(cost);
		 if(mst[v]) continue;
		 // System.out .println(cost);		 
		 mst[v]=true;
		 totalcost+=cost;
		 parent[v]=p.parent;
		 for(int x=0;x<n;x++){
			 // System.out .println(city[v][x]);
			 if(!mst[x] && city[v][x]!=0){
				 pq.add(new pair(x,city[v][x],v));
				 // System.out .println(city[v][x]);
			 }
		 }
	 }
	 return totalcost;
	 
 }
}

public class Main {
    // Driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int city[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                city[i][j] = sc.nextInt();
        }

        System.out.println(Solution.findcost(n, city));

    }
}
//kruskal's Algorithms
import java.util.*;
class DSU{
	private int[]parent;
	private int[]size;
	DSU(int n){
		parent=new int[n];
		size=new int[n];
		for(int i=0;i<n;i++){
			size[i]=1;
			parent[i]=i;
		}
	}
	int find(int x){
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);//using path compression
	}
	void union(int a,int b){
		a=find(a);
		b=find(b);
		if(a!=b){
			//assuming size of b is small
			if(a<b){
				int temp =a;
				a=b;
				b=temp;
			}
			parent[b]=a;
			size[a]+=size[b];
		}
	}
}
class pair{
	int a;
	int b;
	int wt;
	public pair(int a, int b ,int wt){
		this.a=a;
		this.b=b;
		this.wt=wt;
	}
}
class Solution {
    static int findcost(int n, int city[][]) {
        //Write your code here
		DSU d=new DSU(n);
		int cost=0;
		ArrayList<pair>arr=new ArrayList<>();
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(city[i][j]!=0){
					arr.add(new pair(i,j,city[i][j]));
				}
			}
		}
		Collections.sort(arr,new Comparator<pair>(){
			public int compare(pair p, pair q){
				return p.wt-q.wt;
			}
		});
		// for(pair x:arr)
		// System.out.print(x.wt+" ");
		for(pair p:arr){
			int a=p.a;
			int b=p.b;
			a=d.find(a);
			b=d.find(b);
			if(a!=b){
				d.union(a,b);
				cost+=p.wt;
			}
		}
		return cost;
    }

}

public class Main {
    // Driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int city[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                city[i][j] = sc.nextInt();
        }

        System.out.println(Solution.findcost(n, city));

    }
}
