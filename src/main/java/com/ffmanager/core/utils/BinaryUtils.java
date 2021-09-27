package com.ffmanager.core.utils;

public class BinaryUtils {
    private BinaryUtils() {
            // Utility class
    }

    /**
     * Returns an array of ints that represent the input integer in binary.
     * @param number the integer
     */
    public static int[] integerToBinary(int number) {

        // Creating and assigning binary array size
        int[] binary = new int[35];
        int id = 0;

        // Number should be positive
        while (number > 0) {
            binary[id++] = number % 2;
            number = number / 2;
        }

        return binary;
    }

}
