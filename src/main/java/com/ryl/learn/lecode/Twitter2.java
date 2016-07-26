package com.ryl.learn.lecode;

import java.util.*;

/**
 * 存储所有tweet
 * 用户的订阅关系
 * 每次getNewsFeed时,根据订阅关系,动态从所有tweet中获取列表
 * 逻辑更清晰,实现也简单
 * bug-free ac
 * Created on 16/7/26 上午10:43.
 */
public class Twitter2 {

    Map<Integer,Set<Integer>> subscribeMap; // follower : followees
    List<Tweet> allTweets;

    /** Initialize your data structure here. */
    public Twitter2() {
        subscribeMap = new HashMap<Integer, Set<Integer>>();
        allTweets = new ArrayList<Tweet>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        allTweets.add(new Tweet(userId, tweetId));
        Set<Integer> set = subscribeMap.get(userId);
        if(set == null) {
            //首次订阅自己
            set = new HashSet<Integer>();
            set.add(userId);
            subscribeMap.put(userId, set);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     * */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<Integer>();
        if(allTweets.size() == 0) {
            return list;
        }
        Set<Integer> set = subscribeMap.get(userId);
        if(set == null) {
            set = new HashSet<Integer>();
            set.add(userId);
            subscribeMap.put(userId, set);
        }
        int len = allTweets.size();
        int i = 0;
        while (true) {
            int index = len - 1 - i;
            if(index < 0 || list.size() >= 10) break;
            Tweet t = allTweets.get(index);
            if(set.contains(t.getUserId())) {
                list.add(t.getTweetId());
            }
            i++;
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> set = subscribeMap.get(followerId);
        if(set == null) {
            set = new HashSet<Integer>();
            set.add(followerId);
            set.add(followeeId);
            subscribeMap.put(followerId, set);
        } else {
            set.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> set = subscribeMap.get(followerId);
        if(set == null) {
            set = new HashSet<Integer>();
            set.add(followerId);
            subscribeMap.put(followerId, set);
        } else {
            set.remove(followeeId);
        }
    }

    class Tweet {
        private Integer userId;
        private Integer tweetId;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getTweetId() {
            return tweetId;
        }

        public void setTweetId(Integer tweetId) {
            this.tweetId = tweetId;
        }

        public Tweet(Integer userId, Integer tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    public static void main(String[] args) {
        Twitter2 obj = new Twitter2();
        obj.postTweet(1, 5);
        obj.postTweet(2, 3);
        obj.postTweet(1, 101);
        obj.postTweet(2, 13);
        obj.postTweet(2, 10);
        obj.postTweet(1, 2);
        obj.postTweet(1, 94);
        obj.postTweet(2, 505);
        obj.postTweet(1, 333);
        obj.postTweet(2, 22);
        obj.postTweet(1, 11);
        obj.postTweet(1, 205);
        obj.postTweet(2, 203);
        obj.postTweet(1, 201);
        obj.postTweet(2, 213);
        obj.postTweet(1, 200);
        obj.postTweet(2, 202);
        obj.postTweet(1, 204);
        obj.postTweet(2, 208);
        obj.postTweet(2, 233);
        obj.postTweet(1, 222);
        obj.postTweet(2, 211);
        List<Integer> list = obj.getNewsFeed(1);
        System.out.println(list);
        obj.follow(1,2);
        list = obj.getNewsFeed(1);
        System.out.println(list);
        obj.unfollow(1,2);
        list = obj.getNewsFeed(1);
        System.out.println(list);
    }

}
