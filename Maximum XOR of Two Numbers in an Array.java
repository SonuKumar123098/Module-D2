// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
class TrieNode{
    TrieNode[]child;
    public TrieNode(){
        child=new TrieNode[2];
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    void insert(int num){
        TrieNode node=root;
        for(int i=31;i>=0;i--){
            int bit =(num>>i)&1;
            if(node.child[bit]==null){
                node.child[bit]=new TrieNode();
            }
            node=node.child[bit];
        }
    }
    int getMax(int num){
        TrieNode node=root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.child[1-bit]!=null){
                bit=1-bit;
                ans=(ans | (1<<i));
            }
            node=node.child[bit];
        }
        return ans;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        int ans=0;
        Trie T=new Trie();
        for(int i=0;i<n;i++){
            T.insert(nums[i]);
        }
        for(int i=0;i<n;i++){
            ans=Math.max(ans,T.getMax(nums[i]));
        }
        return ans;
    }
}
