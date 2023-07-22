// https://practice.geeksforgeeks.org/problems/count-of-distinct-substrings/1

class TrieNode{
    TrieNode[]child;
    public TrieNode(){
        child=new TrieNode[26];
        // for(int i=0;i<26;i++){
        //     child[i]=null;
        // }
    }
}
/*You are required to complete this method */
class GfG
{
   public static int countDistinctSubstring(String st)
   {
       //your code here
       int ans=1;
       int n=st.length();
       TrieNode root=new TrieNode();
       for(int i=0;i<n;i++){
           TrieNode node=root;
           for(int j=i;j<n;j++){
               char c=st.charAt(j);
               if(node.child[c-'a']==null){
                   node.child[c-'a']=new TrieNode();
                   ans++;
               }
               node=node.child[c-'a'];
           }
       }
       return ans;
   }
}
