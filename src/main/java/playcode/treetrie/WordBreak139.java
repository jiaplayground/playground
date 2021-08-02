package playcode.treetrie;
import java.util.*;
//

public class WordBreak139 {

    private Trie root;
    private Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        memo = new Boolean[s.length()];
        for(String word : wordDict){
            add(root, word);
        }
        return dfs(s, 0, root);
    }
    private boolean dfs(String s, int pos, Trie root){
        if(memo[pos]!=null){
            return memo[pos];
        }
        Trie node = root;
        for(int i=pos; i<s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(node.children[ch] != null){
                node = node.children[ch];
                if(node.isEnd){
                    if(i==s.length()-1){
                        return true;
                    }
                    if(dfs(s, i+1, root)){
                        memo[pos] =true;
                        return true;
                    }
                }
            }
            else {
                break;
            }
        }
        memo[pos] =false;
        return false;
    }

    public void add(Trie root, String word){

        for(char ch : word.toCharArray()){
            if(root.children[ch-'a']!=null){
                root = root.children[ch-'a'];
            }
            else {
                root.children[ch-'a'] = new Trie();
                root = root.children[ch-'a'];
            }
        }
        root.isEnd = true;
    }

    public static class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie(){
            children = new Trie[26];
        }
    }


    public boolean wordBreakVDP(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i=0; i<length; i++){
            for(int j=i+1; j<=length; j++){
                String part = s.substring(i, j);
                if(words.contains(part) && dp[i]){
                    dp[j] = true;
                }
            }
        }
        return dp[length];
    }
}
