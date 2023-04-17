//https://course.acciojob.com/idle?question=1dcbd139-1ad2-45ca-9705-5184b1a0b922
class Solution {
        public static int[] solve(int[] arr) {
        // Your code here
			int n=arr.length;
			int []ans=new int[n];
			Stack<Integer>st=new Stack<>();
			for(int i=0;i<n;i++){
				while(!st.empty() && arr[st.peek()]<=arr[i])
					st.pop();
				if(st.empty()) ans[i]=-1;
				else ans[i]=i-st.peek();
				st.push(i);
			}
			return ans;
    }
}
