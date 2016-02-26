package com.ryl.learn.puzzlers;

public class T38 {
    public static final long GUEST_USER_ID = -1;
    private static long USER_ID;

    static {
        try {
            USER_ID = getUserId();
        } catch (IdUnavailableException e) {
            USER_ID = GUEST_USER_ID;
            System.out.println("logging in as guest.");
        }
    }

    private static long getUserId() throws IdUnavailableException {
        throw new IdUnavailableException();
    }

    public static void main(String[] args) {
        System.out.println(USER_ID);
    }
}

class IdUnavailableException extends Exception {
    IdUnavailableException() {
    }
}