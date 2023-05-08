//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//https://course.acciojob.com/idle?question=ca1bfbb8-a8f1-4736-9dac-578e50615064
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int l=matrix[0][0];
        int h=matrix[n-1][n-1];
        while(l<h){
            int m=l+(h-l)/2;
            int cnt=countSmallerNumber(m,matrix,n);
            if(cnt >= k)h=m;
            else l=m+1;
        }
        return l;
    }
    private int countSmallerNumber(int m,int[][] matrix, int n){
        int ans=0;

        for(int i=0;i<n;i++){
           if(matrix[i][0]>m) return ans;
           else if(matrix[i][n-1]<=m) ans+=n;
            else{
                int temp=0;
                int l=0; int h=n-1;
                while(l<h){
                    int mid=l+(h-l+1)/2;
                    if(matrix[i][mid]>m) h=mid-1;
                    else{ 
                        l=mid;
                    }
                }
                ans+=l+1;
            }
        }
        return ans;
    }
}
