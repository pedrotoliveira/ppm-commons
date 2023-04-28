package br.com.ppm.commons.array;

import br.com.ppm.commons.validation.ArgumentValidator;

public interface Arrays {

    static boolean isEmpty(final Object[] array) {
        ArgumentValidator.notNullParameter(array, "array");
        if (array.length == 0) return true;
        boolean empty = true;
        for (Object element: array) {
            if (element != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }
}
