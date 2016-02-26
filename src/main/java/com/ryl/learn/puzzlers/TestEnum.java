package com.ryl.learn.puzzlers;

public enum TestEnum {
    REN(1), LIU(2);

    private int index;

    private TestEnum(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        for (TestEnum te : TestEnum.values()) {
            System.out.println(te.name() + te.getIndex());
        }
    }

    public int getIndex() {
        return index;
    }
}
