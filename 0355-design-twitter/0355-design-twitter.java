import java.util.*;

class Twitter {

    private static int timeStamp = 0;

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followees;
        Tweet tweetHead;

        User(int id) {
            this.id = id;
            followees = new HashSet<>();
            follow(id); // user follows self
            tweetHead = null;
        }

        void follow(int followeeId) {
            followees.add(followeeId);
        }

        void unfollow(int followeeId) {
            if (followeeId != this.id) {
                followees.remove(followeeId);
            }
        }

        void post(int tweetId) {
            Tweet t = new Tweet(tweetId);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    private User getUser(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
        return userMap.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        User user = userMap.get(userId);
        for (int followeeId : user.followees) {
            Tweet t = userMap.get(followeeId).tweetHead;
            if (t != null) {
                maxHeap.offer(t);
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);
            if (t.next != null) {
                maxHeap.offer(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/*
Time Complexity

postTweet → O(1)

follow / unfollow → O(1)

getNewsFeed → O((F + 10) log F)
where F = number of followees

💾 Space Complexity

O(U + T)

U = number of users

T = total tweets stored
*/

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */