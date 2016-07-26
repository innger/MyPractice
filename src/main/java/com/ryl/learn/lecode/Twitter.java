package com.ryl.learn.lecode;

import java.util.*;

/**
 * 355. Design Twitter
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * <p>
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * <p>
 * follow(followerId, followeeId): Follower follows a followee.
 * <p>
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * <p>
 * Created on 16/7/25 下午2:16.
 */
public class Twitter {

    Map<Integer, List<Integer>> userMap; //post tweet,发送给每个订阅者的tweet
    Map<Integer, Set<Integer>> subscribeMap; //订阅关系 pub-sub 1:n
    Map<Integer, List<Integer>> tweetMap; //用户自己发送的tweet
    List<Integer> allTweets; //全部的tweet 记录顺序

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<Integer, List<Integer>>();
        subscribeMap = new HashMap<Integer, Set<Integer>>();
        tweetMap = new HashMap<Integer, List<Integer>>();
        allTweets = new ArrayList<Integer>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        allTweets.add(tweetId);
        List<Integer> tweetList = tweetMap.get(userId);
        boolean init = false;
        if (tweetList == null) {
            tweetList = new ArrayList<Integer>();
            tweetList.add(tweetId);
            tweetMap.put(userId, tweetList);
            init = true;
        } else {
            tweetList.add(tweetId);
        }
        Set<Integer> scriber = subscribeMap.get(userId); //获取所有订阅者
        if (scriber == null) {
            scriber = new HashSet<Integer>();
            scriber.add(userId); //添加自己为订阅者
            subscribeMap.put(userId, scriber);
        }
        if (init) {
            //首次发tweet,订阅自己
            scriber.add(userId);
        }
        scriber.add(userId);
        for (Integer scriberId : scriber) {
            //发送给每个订阅者
            List<Integer> list = userMap.get(scriberId);
            if (list != null) {
                list.add(tweetId);
            } else {
                list = new ArrayList<Integer>();
                list.add(tweetId);
                userMap.put(userId, list);
            }
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = userMap.get(userId);
        List<Integer> result = new ArrayList<Integer>();
        if (list == null) {
            return result;
        } else {
            int i = 0;
            int len = list.size();
            while (true) {
                int index = len - i - 1;
                if(i >= 10 || index < 0 ) break;
                result.add(list.get(index));
                i++;
            }
            return result;
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> set = subscribeMap.get(followeeId);
        if (set == null) {
            set = new HashSet<Integer>();
            set.add(followerId);
            subscribeMap.put(followeeId, set);
        } else {
            //重复follow
            if (set.contains(followerId)) return;
            set.add(followerId);
        }
        //获取followeeId之前发布的tweet
        List<Integer> posted = tweetMap.get(followeeId);
        if (posted == null || posted.isEmpty()) return;
        List<Integer> tweets = userMap.get(followerId);
        if (tweets == null || tweets.isEmpty()) {
            tweets = new ArrayList<Integer>();
            userMap.put(followerId, tweets);
        }
        int i = 0;
        List<Integer> res = new ArrayList<Integer>();
        int len = allTweets.size();
        while (true) {
            int index = len - i - 1;
            if (index < 0 ) break;
            int n = allTweets.get(index);
            if (posted.contains(n) || tweets.contains(n)) {
                res.add(n);
            }
            i++;
        }
        Collections.reverse(res);
        userMap.put(followerId, res);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> set = subscribeMap.get(followeeId);
        if (set != null) {
            set.remove(followerId);
            //移除之前订阅的消息
            List<Integer> tweetList = tweetMap.get(followeeId);
            if (tweetList == null) {
                return;
            }
            List<Integer> list = userMap.get(followerId);
            if (list != null) {
                list.removeAll(tweetList);
                /*Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()) {
                    Integer tweetId = iterator.next();
                    if(tweetList.contains(tweetId)) {
                        iterator.remove();
                    }
                }*/
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

    public static void main(String[] args) {
        Twitter obj = new Twitter();
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
