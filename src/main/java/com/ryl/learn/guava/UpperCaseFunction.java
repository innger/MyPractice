package com.ryl.learn.guava;

import com.google.common.base.Function;

/**
 * Created on 16/10/31 11:20.
 */
public class UpperCaseFunction<F, T> implements Function<F, T> {
    @Override
    public Object apply(Object input) {
        return input.toString().toUpperCase();
    }
}
