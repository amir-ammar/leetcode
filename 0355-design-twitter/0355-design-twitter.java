class Twitter {

    static class Tweet {
            int tweetId;
            int userId;
            Tweet(int tweetId, int userId) {
                this.tweetId = tweetId;
                this.userId = userId;
            }
        }

        ArrayList<HashSet<Integer>> usersMemory;

        ArrayList<Tweet> tweets;

        public Twitter() {
            usersMemory = new ArrayList<>();
            tweets = new ArrayList<>();
            for (int i = 0; i < 500; i++) {
                usersMemory.add(new HashSet<>());
            }
        }

        public void postTweet(int userId, int tweetId) {
            tweets.add(new Tweet(tweetId, userId));
        }

        public List<Integer> getNewsFeed(int userId) {
            ArrayList<Integer> result = new ArrayList<>();
            int count = 0;
            for (int i = tweets.size() - 1; i >= 0; i--) {
                Tweet tweet = tweets.get(i);
                if (tweet.userId == userId || usersMemory.get(tweet.userId).contains(userId)) {
                    result.add(tweet.tweetId);
                    count++;
                    if (count == 10) {
                        break;
                    }
                }
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            usersMemory.get(followeeId).add(followerId);
        }

        public void unfollow(int followerId, int followeeId) {
            usersMemory.get(followeeId).remove(followerId);
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