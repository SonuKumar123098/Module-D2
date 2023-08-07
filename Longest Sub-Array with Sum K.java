// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
// https://course.acciojob.com/idle?question=00d425f1-a20e-4549-afb2-4e1cd07ad3fd
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int nums[], int n, int k) {
        //Complete the function
        // int n=nums.length;
        Map<Integer,Integer>prefixSum=new HashMap<>();//(prefixsum,frequency)
        int sum=0;
        int ans=0;
        prefixSum.put(0,-1);
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(prefixSum.containsKey(sum-k)){
                ans=Math.max(ans,i-prefixSum.get(sum-k));
            }
            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum,i);
            }
        }
        return ans;
    }
}
