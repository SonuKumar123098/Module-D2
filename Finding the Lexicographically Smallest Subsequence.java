//https://course.acciojob.com/idle?question=718f4bb3-0762-4a4e-a6db-2dfff2c4380d
class Solution
{
    static void smallestSubsequence(String s, int k)
    {
        // Your code here
		Stack<Character>st=new Stack<>();
		char[]arr= s.toCharArray();
		for(int i=0;i<=s.length()-k;i++){
			while(!st.empty() && st.peek()>arr[i]) st.pop();
			st.push(arr[i]);
		}
		for(int i=s.length()-k+1;i<s.length();i++){
			while((st.size()+s.length()-i-1)>=k && st.peek()>arr[i]) st.pop();
			st.push(arr[i]);
		}
		while(st.size()>k) st.pop();
		StringBuilder sb=new StringBuilder();
		while(st.size()>0)sb.append(st.pop());
		sb.reverse();
		System.out.println(sb.toString());
	}
}
