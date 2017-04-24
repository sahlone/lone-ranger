package com.sahil.lr.utils;

import java.util.Random;

/**
 * Utility class that provides generating random numbers logic
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class RandomUtil {

    private static Random random = new Random();

    /**
     * Generate and return random number according to given base
     *
     * @param bound the upper bound (exclusive).  Must be positive.
     * @return the next pseudorandom, uniformly distributed {@code int}
     * value between zero (inclusive) and {@code bound} (exclusive)
     */
    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Generate and return random number according to given base
     *
     * @param min lower bound (exclusive) must be positive
     * @param max upper bound (exclusive) must be positive
     * @return the next pseudorandom, uniformly distributed {@code int}
     * value between {@code min} (exclusive) and {@code max} (exclusive)
     */
    public static int nextIntInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
