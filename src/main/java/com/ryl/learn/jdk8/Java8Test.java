package com.ryl.learn.jdk8;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

    public static void main(String[] args) {

        Runnable r = () -> System.out.print("hello lambda");
        r.run();
        List<String> list = Arrays.asList("t1", "t2", "t334", "t4", "t567");
        list.parallelStream().filter(s -> s.length() == 2).forEach(System.out::println);

        list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "15", "17");
        Map<String, Integer> integers = list.stream()
                .map(Integer::new)
                .filter(e -> e % 2 != 0)
                .distinct().collect(Collectors.toMap(Object::toString, e -> e));
        System.out.println(integers);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        new Thread(() -> System.out.println("hello lambda")).start();
        new Thread(() -> {
            System.out.println("hello lambda");
        }).start();

        List<String> words = Lists.newArrayList("ren", "wang", "li", "zhao", "ma");
        words.sort((w1, w2) -> Integer.compare((w1.length()), w2.length()));

        List<Integer> ints = Ints.asList(1, 2, 3, 4, 5);
        ints.sort(Integer::compare);


//        words.forEach(e -> System.out.print(e));
        words.forEach(System.out::println);

//        words.stream().map(w -> w.length());
        words.stream().map(String::length);

//        words.stream().map(w -> new StringBuilder(w));
        words.stream().map(StringBuilder::new);

        Converter<String, Integer> converter; //(f) -> Integer.valueOf(f);
        converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);

        String[] arrayStr = new String[]{"a", "ab", "abc", "abcd"};

        Arrays.sort(arrayStr, (first, second) -> Integer.compare(first.length(), second.length()));
    }

    interface Command {
        String set();

        String m1();

        default void m2() {
            System.out.println("this is a defaul method in the interface");
        }

        static void m3() {
            System.out.println("this is a static method in the interface");
        }

        default String get() {
            return "123";
        }
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }
}




