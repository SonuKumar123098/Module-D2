//https://leetcode.com/contest/weekly-contest-342/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
class Solution {
public:
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    int minOperations(vector<int>& nums) {
        int cnt=0;
        int n=nums.size();
        for(int i=0;i<n;i++) if(nums[i]==1) cnt++;
        if(cnt>0) return n-cnt;
        int ans=INT_MAX;
        for(int i=0;i<n-1;i++){
            int k=0;
            for(int j=i;j<n;j++){
                k=gcd(k,nums[j]); 
                if(k==1){
                    ans=min(ans,n-1+(j-i));
                }
            }
        }
        return ans==INT_MAX?-1:ans;
    }
};
