//https://leetcode.com/contest/weekly-contest-342/problems/sliding-subarray-beauty/
class Solution {
public:
    int getMin(map<int,int>&m,int x){
        int cnt=0;
        for(auto it=m.begin();it!=m.end();it++){
            if(it->first<0){
                cnt+=it->second;
            }else return 0;
            if(cnt>=x) return it->first;
        }
        return 0;
    }
    vector<int> getSubarrayBeauty(vector<int>& nums, int k, int x) {
        int n=nums.size();
        map<int,int>m;
        vector<int>ans(n-k+1,0);
        for(int i=0;i<k;i++){
            m[nums[i]]++;
        }
        for(int i=k;i<n;i++){
            ans[i-k]=getMin(m,x);
            m[nums[i-k]]--;
            if( m[nums[i-k]]==0){
                m.erase(m.find(nums[i-k]));
            }
            m[nums[i]]++;
        }
        ans[n-k]=getMin(m,x);
        return ans;
    }
};
