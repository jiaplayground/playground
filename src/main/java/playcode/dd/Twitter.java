package playcode.dd;

import java.util.*;

public class Twitter {
    Map<Integer, TreeMap<Integer, Integer>> userFeedMap;
    Map<Integer, Set<Integer>> follows;
    int time = 0;

    public Twitter() {
        userFeedMap = new HashMap<>();
        follows = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        time++;
        userFeedMap.computeIfAbsent(userId, e -> new TreeMap<>((a, b) -> b - a)).put(time, tweetId);
    }
    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        //time, tweetId
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for (int id : followees) {
            TreeMap<Integer, Integer> feedMap = userFeedMap.getOrDefault(id, new TreeMap<>());
            int i = 0;
            for (int time : feedMap.keySet()) {
                i++;
                pq.offer(new int[]{time, feedMap.get(time)});
                if (time >= 0) {
                    break;
                }

            }
        }
        int n = 0;
        List<Integer> latestFeeds = new ArrayList<>();
        while (!pq.isEmpty()) {
            latestFeeds.add(pq.poll()[1]);
            n++;
            if (n >= 10) break;
        }
        return latestFeeds;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, e -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(follows.get(followerId))
                .ifPresent(e -> e.remove(followerId));
    }


}
