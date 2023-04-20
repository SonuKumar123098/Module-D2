//https://leetcode.com/problems/unique-binary-search-trees-ii/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateRange(1,n);
    }
    private List<TreeNode> generateRange(int l,int h){
        List<TreeNode>ans=new ArrayList<>();
        if(l>h){
            ans.add(null);
            return ans;
        }
        for(int i=l;i<=h;i++){
            List<TreeNode>left=generateRange(l,i-1);
            List<TreeNode>right=generateRange(i+1,h);
            for( TreeNode lr:left){
                for(TreeNode rr:right){
                    TreeNode root=new TreeNode(i);
                    root.left=lr;
                    root.right=rr;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
