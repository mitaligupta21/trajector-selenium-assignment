package com.pages;

import java.util.Random;

public class RandomDataGenerator {
    private static final String[] NAMES = {"John", "Jane", "Alex", "Emily", "Chris", "Katie"};
    private static Random random = new Random();

    public static String getRandomName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

    public static String getRandomFirstName() {
        return getRandomName();
    }

    public static String getRandomLastName() {
        return getRandomName();
    }
}
