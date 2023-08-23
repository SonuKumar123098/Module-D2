//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/
// https://course.acciojob.com/idle?question=8fef544e-f7da-40af-9a03-b137205ba36f
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer>arr=new ArrayList<>();
        int n=nums.length;
        if(n==1)return 0;
        for(int i=0;i<n-1;i++){
            arr.add(nums[i]);
            while(i<n-1 && nums[i+1]==nums[i])i++;
        }
        if(arr.get(arr.size()-1)!=nums[n-1]) arr.add(nums[n-1]);
        int m=arr.size();
        int j=0;int len=0;
        for(int i=0;i<m;i++){
            while(j<i && arr.get(i)-arr.get(j)>(n-1)) j++;
            len=Math.max(len,i-j+1);
        }
        return n-len;
    }
}
