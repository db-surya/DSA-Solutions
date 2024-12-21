class Twitter {
    HashMap<Integer, HashSet<Integer>> followers;
    HashMap<Integer, ArrayList<int[]>> tweets;
    int count;

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        count = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<int[]>());
        tweets.get(userId).add(new int[] { count, tweetId });
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[0], a[0]);
        });
        // Push user tweets into maxHeap
        if (tweets.containsKey(userId)) {
            ArrayList<int[]> userTweets = tweets.get(userId);
            for (int tweet[] : userTweets) {
                maxHeap.add(tweet);
            }
        }
        // push followers tweet into priority Queue
        if (followers.containsKey(userId)) {
            HashSet<Integer> userFollowers = followers.get(userId);
            for (int follower : userFollowers) {
                if (tweets.containsKey(follower)) {
                    ArrayList<int[]> followerTweets = tweets.get(follower);
                    for (int tweet[] : followerTweets) {
                        maxHeap.add(tweet);
                    }
                }
            }
        }
        int tweetCount = 0;
        List<Integer> tweetsList = new ArrayList<>();
        while (!maxHeap.isEmpty() && tweetCount < 10) {
            tweetsList.add(maxHeap.poll()[1]);
            tweetCount++;
        }
        return tweetsList;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<Integer>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
        followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */