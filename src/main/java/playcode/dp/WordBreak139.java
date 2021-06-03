package playcode.dp;

import java.util.*;

public class WordBreak139 {
    static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    private void add(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }


    boolean canBreak(String s) {
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int pos = 0; pos < size; pos++) {
            if (!dp[pos]) continue;
            TrieNode node = root;
            for (int i = pos; i < size; i++) {
                int c = s.charAt(i) - 'a';
                if (node.children[c] == null) {
                    break;
                }
                node = node.children[c];
                if (node.isWord) {
                    dp[i + 1] = true;
                }
            }
            if (dp[size]) return true;
        }
        return dp[size];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        wordDict.forEach(this::add);
        return canBreak(s);
    }
}
