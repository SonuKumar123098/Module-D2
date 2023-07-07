// https://leetcode.com/problems/implement-trie-prefix-tree/
class TrieNode{
    boolean end;
    TrieNode[]child;
    TrieNode(){
        child=new TrieNode[26];
        end=false;
    }
}class Trie {
TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        if(word.length()==0) return;
        TrieNode cur=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char c =word.charAt(i);
            int index=c-'a';
            if(cur.child[index]==null){
                cur.child[index]=new TrieNode();
            }
            cur=cur.child[index];
        }
        cur.end=true;
    }
    
    public boolean search(String word) {
        if(word.length()==0) return true;
        TrieNode cur=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char c =word.charAt(i);
            int index=c-'a';
            if(cur.child[index]==null){
                return false;
            }
            cur=cur.child[index];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        // return !search(prefix);
        if(prefix.length()==0) return true;
        TrieNode cur=root;
        int n=prefix.length();
        for(int i=0;i<n;i++){
            char c =prefix.charAt(i);
            int index=c-'a';
            if(cur.child[index]==null){
                return false;
            }
            cur=cur.child[index];
        }
        return true;
    }
}
