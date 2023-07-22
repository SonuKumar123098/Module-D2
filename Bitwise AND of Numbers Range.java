// https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int d=right-left+1;
        int ans=0;
        for(int i=31;i>=0;i--){
            if(d<=(1<<i)){
                if(((left>>i)&1)==1 && ((right>>i)&1)==1){
                    ans=ans| (1<<i);
                }
            }
        }
        return ans;
    }
}
