package com.ryl.learn.lecode.NestedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 *
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 *
 * Created on 16/5/12 上午10:50.
 */
public class NestedIterator implements Iterator<Integer> {

    private int index = 0;
    private List<Integer> list = new ArrayList<Integer>();

    private void dfs(List<NestedInteger> nestedList) {
        for(NestedInteger val : nestedList) {
            if(val.isInteger()) {
                list.add(val.getInteger());
            } else {
                dfs(val.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public boolean hasNext() {
        if(index < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }
}
