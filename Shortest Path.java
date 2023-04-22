//https://course.acciojob.com/idle?question=92610f2e-18e2-4b4b-838c-bdebed8f07de
import java.io.*;
import java.util.*;
import java.lang.*;

 class Pair{
	int n;
	int wt;
	Pair(int a,int b){
		this.n=a;
		this.wt=b;
	}
}
public class Main {
  public static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
  {
     // Write your code here
	  PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
		  return a.wt-b.wt;
	  });
	  pq.add(new Pair(s,0));
		  int ans[]=new int[v];
	  Arrays.fill(ans,-1);
       while(pq.size()>0){
		   Pair p=pq.remove();
		   if(ans[p.n]==-1){
			   ans[p.n]=p.wt;
			   for(var arr:adj.get(p.n)){
				   if(ans[arr.get(0)]==-1){
					   pq.add(new Pair(arr.get(0),ans[p.n]+arr.get(1)));
				   }
			   }
		   }
	   }
	  return ans;
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}
