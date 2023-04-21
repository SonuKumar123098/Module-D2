//https://course.acciojob.com/idle?question=b676f879-c0b8-4cf6-b2ba-6e896496cb94
private static int minKey(int[]key,int v,boolean[]mst){
	int k=Integer.MAX_VALUE, ans=0;
	for(int i=0;i<v;i++){
		if(key[i]<k && !mst[i]){
			k=key[i];
			ans=i;
		}
	}
	return ans;
}
  static int primMST(int graph[][], int v) {
    // your code here
	  int key[]=new int[v];
	  boolean mst[]=new boolean[v];
	  int parent[]=new int[v];
	  Arrays.fill(parent,-1);
	  Arrays.fill(key,Integer.MAX_VALUE);
	  key[0]=0;
	  
	  for(int i=1;i<v;i++){
		  int minKey=minKey(key,v,mst);
		  mst[minKey]=true;
		  for(int j=0;j<v;j++){
			  if(graph[minKey][j]!=0 && !mst[j] && graph[minKey][j]<key[j]){
				  parent[j]=minKey;
				  key[j]=graph[minKey][j];
			  }
		  }
	  }
	  int ans=0;
	  for(int i=0;i<v;i++) ans+=key[i];
	  return ans;
  }
