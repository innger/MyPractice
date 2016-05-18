package com.ryl.learn.jdk8.streams;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Streams are extremely powerful
 * Created on 16/5/18 下午4:43.
 */
public class StreamDemo {


    public static void main(String[] args) {
        parallelStream();

    }

    //并发流
    private static void parallelStream() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            values.add(UUID.randomUUID().toString());
        }
        for (int i = 0; i < 10; i++) {
            long t0 = System.nanoTime();
            long count = values.stream().sorted().count();
            long t1 = System.nanoTime();
            long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
            System.out.println(String.format("sequential sort took : %s ms", millis));

            t0 = System.nanoTime();
            count = values.parallelStream().sorted().count();
            t1 = System.nanoTime();
            millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
            System.out.println(String.format("parallel sort took : %s ms", millis));
        }

    }

    private static void stream() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(RandomStringUtils.randomAlphabetic(3).toLowerCase());
        }
        System.out.println(list);

        //filter
        list.stream().filter((s) -> s.startsWith("a")).forEach(System.out::print);

        //Sorted is an intermediate operation which returns a sorted view of the stream.
        //sorted
        list.stream().sorted().filter((s) -> s.startsWith("z")).forEach(System.out::print);

        //map
        list.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::print);

        //match anyMath allMath noneMath
        boolean anyStartWithA = list.stream().anyMatch((s) -> s.startsWith("a"));
        boolean allStartWithA = list.stream().allMatch((s) -> s.startsWith("a"));
        boolean noneStartWithA = list.stream().noneMatch((s) -> s.startsWith("a"));

        //count
        long startWithB = list.stream().filter((s) -> s.startsWith("b")).count();

        //reduce
        Optional<String> reduced = list.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::print);
    }

}
