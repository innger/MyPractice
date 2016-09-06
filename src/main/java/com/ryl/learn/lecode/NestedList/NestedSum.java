package com.ryl.learn.lecode.NestedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 339. Nested List Weight Sum
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 * <p>
 * DFS
 *
 * @see 'http://blog.csdn.net/qq508618087/article/details/51014943'
 * Created on 16/7/26 上午11:28.
 */
public class NestedSum {

    int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger val : list) {
            if (val.isInteger()) {
                sum += val.getInteger() * depth;
            } else {
                sum += dfs(val.getList(), depth + 1);
            }
        }
        return sum;
    }

    int depthSum(List<NestedInteger> list) {
        return dfs(list, 1);
    }

    public static void main(String[] args) {
        NestedSum sum = new NestedSum();
        List<NestedInteger> list = new ArrayList<NestedInteger>();


        System.out.println(sum.depthSum(list));

        List<NestedInteger> list1 = new ArrayList<NestedInteger>();
        System.out.println(sum.depthSum(list1));

    }

}
