// https://leetcode.com/problems/kth-ancestor-of-a-tree-node/


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
