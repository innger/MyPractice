package com.ryl.learn.jdk8.interfaces;

/**
 * Functional interface
 * exactly one abstract method
 * Method and Constructor References
 * Created on 16/5/18 上午11:30.
 */
public class Functional {

    public static void main(String[] args) {

        Converter<String, Integer> converter = Integer::valueOf; //static method references
        // (from) -> Integer.valueOf(from);
        Integer i = converter.convert("123");
        System.out.println(i);

        Something something = new Something();
        Converter<String, String> con = something::startsWith; //object method references 具体方法的实现
        String res = con.convert("Java");
        System.out.println(res);

        PersonFactory<Person> pf = Person::new; //输入输出匹配,不在乎方法名称 string,string -> person
        Person p = pf.create("ren", "yulong");

        //Accessing local variables final
        //num does not have to be declared final
        //However num must be implicitly final for the code to compile
        int num = 1;
        Converter<Integer, String> stringConverter = (from -> String.valueOf(num + from));
        System.out.println(stringConverter.convert(11));

    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {

        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    static class Person {
        private String firstName;
        private String lastName;

        public Person() {
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }


    //Accessing fields and static variables
    static class Lambda4 {
        static int outerStaticNum;
        int outerNum;

        void testScopes() {

            Converter<Integer, String> stringConverter = (from) -> {
                outerNum = 23;
                return String.valueOf(outerNum + from);
            };

            Converter<Integer, String> stringConverter1 = (from) -> {
                outerStaticNum = 23;
                return String.valueOf(outerStaticNum + from);
            };
        }
    }

}
