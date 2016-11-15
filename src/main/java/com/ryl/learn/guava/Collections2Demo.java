package com.ryl.learn.guava;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Set;

/**
 * Created on 16/10/31 11:23.
 */
public class Collections2Demo {
    
    private static Set<String> buildSetStrings() {
        final Set<String> strings = Sets.newHashSet();
        strings.add("Java");
        strings.add("Groovy");
        strings.add("Python");
        strings.add("Jpython");
        strings.add("C");
        strings.add("Cpp");
        return strings;
    }
    
    private static void demonstrateFilter() {
        Set<String> strings = buildSetStrings();
        //过滤以 J 开头的字符串
        Collection<String> filtered = Collections2.filter(strings, Predicates.containsPattern("^J"));
        System.out.println(filtered);
    }
    
    private static void demonstrateTransform() {
        Set<String> strings = buildSetStrings();
        Collection<String> transformed = Collections2.transform(strings, new UpperCaseFunction<String, String>());
        System.out.println(transformed);
    }
    
    public static void main(String[] args) {
        demonstrateFilter();
        demonstrateTransform();
    }
    
    
}
