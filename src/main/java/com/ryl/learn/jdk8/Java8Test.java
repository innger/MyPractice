package com.ryl.learn.jdk8;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

    public static void main(String[] args) {
        lambdaTest();
        stringTest();
        patternTest();
        filesTest();
        optionalTest();
        collectionTest();
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

    static void lambdaTest() {
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

    static void stringTest() {
        String s1 = String.join(":", "alibaba", "icbu", "youguang");
        System.out.println(s1);

        String s2 = String.join(":", Lists.newArrayList("alibaba", "icbu", "youguang"));
        System.out.println(s2);

        //创建一个字符流 统计去重后的字符数
        long count = s2.chars().distinct().count();
        System.out.println(s2 + " distinct char count=" + count);

        StringJoiner joiner = new StringJoiner(":");
        joiner.add("alibaba");
        joiner.add("icbu");
        joiner.add("youguang");
        System.out.println("StringJoiner toString=" + joiner.toString());

        joiner = new StringJoiner(":", "prefix-", "-suffix");
        joiner.add("alibaba");
        joiner.add("icbu");
        joiner.add("youguang");
        System.out.println("StringJoiner toString prefix&suffix=" + joiner.toString());

    }

    static void patternTest() {
        String test = "alibaba:icbu:youguang";
        //Pattern.splitAsStream()
        String bar = Pattern.compile(":")
                .splitAsStream(test)
                .filter(s -> !s.contains("youguang"))
                .collect(Collectors.joining(":"));
        System.out.println("Pattern.splitAsStream bar=" + bar);

        //Pattern.asPredicate()
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        long c = Stream.of("tony@gmail.com", "tony.liw@alibaba-inc.com").filter(pattern.asPredicate()).count();
        System.out.println("Pattern.asPredicate count=" + c);

    }

    static void filesTest() {
        //Files.list
        try {
            try (Stream<Path> stream = Files.list(Paths.get("/opt"))) {
                String joined = stream.map(String::valueOf)
                        .filter(path -> !path.startsWith("."))
                        .sorted().collect(Collectors.joining("; "));
                System.out.println("List path /opt : " + joined);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.find
        Path start = Paths.get("/Users/alibaba/Downloads/2016113");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) -> String.valueOf(path).endsWith(".js"))) {
            String joined = stream.sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; "));
            System.out.println("Files find : " + joined);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.walk
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream.map(String::valueOf)
                    .filter(path -> path.endsWith(".js"))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("Files walk : " + joined);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.readAllLines
        try {
            String p = "/Users/alibaba/linuxsir.txt";
            List<String> lines = Files.readAllLines(Paths.get(p));
            lines.add("print('foobar');");
            Files.write(Paths.get(p), lines);
            lines.remove(lines.size() - 1);
            System.out.println("readAllLines " + lines);
            Files.write(Paths.get(p), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.lines
        try (Stream<String> stream = Files.lines(Paths.get("/Users/alibaba/linuxsir.txt"))) {
            stream.filter(line -> line.contains("w"))
                    .map(String::valueOf)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.newBufferedReader&Files.newBufferedWriter
        Path path = Paths.get("/Users/alibaba/linuxsir.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = Paths.get("/Users/alibaba/output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("print('Hello World')");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void optionalTest() {
        //不要这样,这与!=null没什么区别
        Optional<String> stringOptional = Optional.of("alibaba");
        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get().length());
        }
        Optional<String> optionalValue = Optional.of("alibaba");
        //下面是推荐的常用操作
        optionalValue.ifPresent(s -> System.out.println(s + " contains red"));
        //增加到集合汇总
        List<String> results = Lists.newArrayList();
        optionalValue.ifPresent(results::add);
        //增加到集合中，并返回操作结果
        Optional<Boolean> added = optionalValue.map(results::add);

        //无值的optional
        Optional<String> optionalString = Optional.empty();
        //不存在值，返回“No word”
        String result = optionalValue.orElse("No word");
        //没值，计算一个默认值
        result = optionalString.orElseGet(() -> System.getProperty("user.dir"));
        //无值，抛一个异常
        try {
            result = optionalString.orElseThrow(NoSuchElementException::new);
        } catch (Throwable t) {
            t.getCause();
        }
    }

    static void collectionTest() {
        //removeIf
        Collection<String> c = new HashSet<>();
        c.add("Content 1");
        c.add("Content 2");
        c.add("Content 3");
        c.add("Content 4");
        c.removeIf(s -> s.contains("2"));
        System.out.println("removeIf : " + c);

        ///基本操作
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        list.removeIf(a -> a % 3 == 0);
        System.out.println("a % 3 == 0 " + list);

        //OR 操作
        Predicate<Integer> predicate2 = a -> a % 3 == 0;
        Predicate<Integer> predicate3 = a -> a % 5 == 0;
        list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        list.removeIf(predicate2.or(predicate3));
        System.out.println("a % 3 == 0 or a % 5 == 0 " + list);

        //AND 操作
        predicate2 = a -> a % 3 == 0;
        predicate3 = a -> a % 5 == 0;
        list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        list.removeIf(predicate2.and(predicate3));
        System.out.println("a % 3 == 0 and a % 5 == 0 " + list);

        List<String> stringList = Arrays.asList("a", "b");
        stringList.forEach(System.out::println);

        stringList = Arrays.asList("a", "b", "c");
        stringList.replaceAll(String::toUpperCase);
        System.out.println(stringList);//[A, B, C]

        stringList = Arrays.asList("a", "b", "c");
        stringList.sort(String::compareTo);

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
        System.out.println(map.getOrDefault("D", 40));// => 40

    }
}




