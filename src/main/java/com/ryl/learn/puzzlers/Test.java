package com.ryl.learn.puzzlers;


public class Test {

    public static void main(String[] args) {
        Animal cat = new Cat();
        System.out.println(cat.name); //取父类name
        cat.speak();

        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " " + s.ordinal() + " " + s.equals(Shrubbery.CRAWLING));
        }
    }

    enum Shrubbery {GROUND, CRAWLING, HANGING}

    static class Animal {

        String name = "Animal";

        public Animal() {
            System.out.println("Animal constructor.");
        }

        public void speak() {
            System.out.println("Animal speak.");
        }
    }

    static class Cat extends Animal {

        String name = "Cat";

        public Cat() {
            System.out.println("Cat constructor.");
        }

        public void speak() {
            System.out.println("Cat speak.");
        }
    }
}


