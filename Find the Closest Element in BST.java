//https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
class Solution
{
    static int ans;
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int K) 
    { 
        // Write your code here
        ans=Integer.MAX_VALUE;
        solve(root,K);
        return ans;
    } 
   private static void solve(Node root,int k){
       if(root==null) return ;
       int diff=Math.abs(root.data-k);
           if(root.data>k)
               solve(root.left,k);
           else if(root.data<k)
               solve(root.right,k);
       ans=Math.min(ans,diff);
       
   }
}
