package com.ryl.learn.jdk8.interfaces;

/**
 * Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the [default] keyword.
 * This feature is also known as virtual extension methods.
 * <p>
 * interface default method
 * Created on 16/5/18 上午10:58.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    //Accessing Default Interface Methods
    //Default methods cannot be accessed from within lambda expressions.
    //The following code does not compile:
    //Formula f = (a) -> sqrt(a * 100);

    static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(100));

    }

}


