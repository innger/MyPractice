package com.ryl.learn.lecode.NestedList;

import java.util.List;

/**
 * This is the interface that allows for creating nested lists.
 * You should not implement it, or speculate about its implementation
 * Created on 16/5/12 上午10:48.
 */
public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();


    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();

}
