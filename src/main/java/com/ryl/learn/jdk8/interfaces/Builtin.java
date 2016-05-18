package com.ryl.learn.jdk8.interfaces;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * https://github.com/winterbe/java8-tutorial#default-methods-for-interfaces
 * <p>
 * JDK 1.8 API contains many built-in functional interfaces
 * <p>
 * Created on 16/5/18 下午3:18.
 */
public class Builtin {


    private static void predicates() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");
        predicate.negate().test("foo");

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

    }

    private static void functions() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> toString = toInteger.andThen(String::valueOf);

        toString.apply("123");
    }

    //Suppliers produce a result of a given generic type. Unlike Functions,
    // Suppliers don't accept arguments.
    private static void suppliers() {
        Supplier<String> sp = String::new;
        sp.get();
    }

    //Consumers represent operations to be performed on a single input argument.
    private static void consumers() {
        Consumer<String> greet = (s) -> System.out.println("Hello, " + s);
        greet.accept("Tom");
    }

    private static void comparators() {
        Comparator<String> comparator = (s1, s2) -> s2.compareTo(s1);
        String s1 = "John";
        String s2 = "Alice";
        comparator.compare(s1, s2);
        comparator.reversed().compare(s1, s2);
    }

    //Optional is a simple container for a value which may be null or non-null.
    //prevent NullPointerException
    private static void optionals() {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent(); //true
        optional.get(); //"bam"
        optional.orElse("fallback"); // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
    }

}
