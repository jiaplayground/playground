package playcode.aoa;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;

public class TopKFrequentWords692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        Queue<String> q = new PriorityQueue<>
                ((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));

        for (String w : map.keySet()) {
            q.offer(w);
            if (q.size() > k) {
                q.poll();
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while (!q.isEmpty()) {
            list.addFirst(q.poll());
        }
        return list;
    }

    public static String[] reorderLogFiles(String[] logs) {
        //10:17
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }
        Collections.sort(letters, (a, b) -> a.split("/\\s/")[1].compareTo(b.split("/\\s/")[1]));
        int i = 0;
        for (String l : letters) {
            logs[i] = l;
            i++;
        }
        for (String d : digits) {
            logs[i] = d;
            i++;
        }
        return logs;
    }

    @Test
    public void t() {
        // reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
    }
}
