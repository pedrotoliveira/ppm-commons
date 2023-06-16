package br.com.ppm.commons.array;

import br.com.ppm.commons.validation.ArgumentValidator;

public interface Arrays {

    static boolean isEmpty(final Object[] array) {
        ArgumentValidator.notNullParameter(array, "array");
        if (array.length == 0) return true;
        boolean empty = true;
        for (Object element : array) {
            if (element != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    static boolean notEmpty(final Object[] array) {
        ArgumentValidator.notNullParameter(array, "array");
        return !isEmpty(array);
    }

    /**
     * Reverse the order of the given array using the same array as reference.
     *
     * @param array the array to reverse
     * @throws IllegalArgumentException if the array is null
     */
    static Object[] reverse(final Object[] array) {
        ArgumentValidator.notNullParameter(array, "array");
        if (array.length == 0) return array;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // swap arr[start] and arr[end]
            Object pointer = array[start];
            array[start] = array[end];
            array[end] = pointer;
            start = start + 1;
            end = end - 1;
        }
        return array;
    }

    /**
     * Create a new array and reverse the order of the given array.
     * <p>
     * This method will return a new array with the elements in reverse order,
     * the given array will NOT be modified.
     *
     *
     * @returnÒÒ
     */
    static Object[] newReverse(final Object[] array) {
        ArgumentValidator.notNullParameter(array, "array");
        if (array.length == 0) return array;
        Object[] reversed = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
