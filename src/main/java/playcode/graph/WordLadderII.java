package playcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        Map<String, List<String>> g = buildGraph(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //a-b         f->t
        //       c
        //a-d         e->t
        Map<String, List<List<String>>> path = new HashMap<>();
        List<String> x = new ArrayList<>();
        List<List<String>> y = new ArrayList<>();
        y.add(x);
        x.add(beginWord);
        path.put(beginWord, y);
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> toVisits = new HashSet<>();
            while (size-- > 0) {
                String from = q.poll();
                for (String to : g.getOrDefault(from, new ArrayList<>())) {
                    if (visited.contains(to)) {
                        continue;
                    }
                    if (!path.containsKey(to)) {
                        path.put(to, new ArrayList<List<String>>());
                    }

                    List<List<String>> newPath = new ArrayList<>();
                    for(List<String> p : path.get(from)){
                        List<String> one = new ArrayList<>(p);
                        one.add(to);
                        newPath.add(one);
                    }

                    path.get(to).addAll(newPath);
                    toVisits.add(to);
                }
                if (toVisits.contains(endWord)) {
                    break;
                }
                q.addAll(toVisits);
                visited.addAll(toVisits);
            }
        }
        return path.getOrDefault(endWord, new ArrayList<>());
    }
    Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> g = new HashMap<>();
        wordList = new ArrayList<>(new HashSet<>(wordList));
        int size = wordList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if (word1.length() != word2.length()) {
                    continue;
                }
                int count=0;
                for (int k = 0; k < word1.length(); k++) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        count++;
                        if(count==2) break;
                    }

                }
                if (count==1) {
                    //System.out.println(word1 + " :: graph:  " + word2);
                    g.computeIfAbsent(word1, e -> new ArrayList<>()).add(word2);
                    g.computeIfAbsent(word2, e -> new ArrayList<>()).add(word1);
                }
            }
        }
        return g;
    }
}
