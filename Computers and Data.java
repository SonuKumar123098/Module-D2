//https://course.acciojob.com/idle?question=5cb1e5af-6cfe-4d86-90bb-1552edd47bbd
class Solution {

    public int minTime(int n, int k, int[] computer, int[] reqTime) {
        // write code here
		int ans=0;
		for(int i=0;i<n;i++){
			ans=Math.max(ans,dfs(computer,reqTime,i));
		}
		return ans;
    }
	private static int dfs(int[]computer,int []reqTime,int i){
		if(computer[i]!=-1){
			reqTime[i]+=dfs(computer,reqTime,computer[i]);
			computer[i]=-1;
		}
		return reqTime[i];
	}

}
