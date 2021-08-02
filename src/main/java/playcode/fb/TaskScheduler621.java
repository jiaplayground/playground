package playcode.fb;
import java.util.*;
public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        //aaabbb=> ab ab ab
        //a3b3c1
        //abcab/ab
        //a4b3c1 // abcab/ab/a N=2  || n=1 abab
        int[] freqs = new int[26];
        for (char ch : tasks) {
            freqs[ch - 'A']++;
        }
        //int[] int[0] letter, int[1] frequence
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freqs[i] > 0)
                pq.offer(freqs[i]);
        }
        int count = 0; //pq{2,2}
        //case abab n=2
        while (!pq.isEmpty()) {
            List<Integer> out = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {//i=0 out 1 pq{2} i=1 out{1,1} pq{} i=2 count1
                //i=0 out{1}, pq{1} out {} pq{} out{} count =1 return
                if (!pq.isEmpty()) {
                    int top = pq.poll();
                    top--;
                    if (top > 0) {
                        out.add(top);
                    }
                    count++;
                } else {
                    if (out.isEmpty()) {
                        return count;
                    } else {
                        count++;
                    }
                }
            }
            pq.addAll(out);
        }
        return count;
    }





}
