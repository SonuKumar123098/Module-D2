// https://course.acciojob.com/idle?question=fc6c8e12-e728-4a01-9237-93a3a25f4a66
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

      System.out.println("Largest Path = " + lpath + "@" + lpathwt);
      System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
   }
   
    //Solution

   static String lpath;
   static Integer lpathwt = Integer.MIN_VALUE;
   static String fpath;
   static Integer fpathwt = Integer.MIN_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      //write code here
      //All variables have been initialized for you at the top of the function
	   if(src==dest){
		   String curPath=psf;
		   //calculating floor path
		   if(fpathwt<wsf && wsf<criteria){
			   fpathwt=wsf;
			   fpath=curPath;
		   }
		   // calculating largest path
		   if(lpathwt<wsf){
			   lpathwt=wsf;
			   lpath=curPath;
		   }
		   // maintain k largest path in priorityQueue
		   pq.add(new Pair(wsf,curPath));
		   if(pq.size()>k) pq.remove();
		   return;
	   }
	   visited[src]=true;
	   for(Edge e:graph[src]){
		   if(visited[e.nbr]) continue;
		   multisolver(graph,e.nbr,dest,visited,criteria,k,psf+e.nbr,wsf+e.wt);
	   }
	   visited[src]=false;
   }
}
