package com.kiandashopping.kiandashopping.util;

import java.util.List;

public class ValueTransfer<T> {

    public interface Listener<T> {
        String getComparableValue(T t);
    }

    public interface Transfer<T> {
        void copy(T t, T t2);
    }

    public ValueTransfer(List<T> list, List<T> list2, Listener<T> listener, Transfer<T> transfer) {
        for (T next : list) {
            for (T next2 : list2) {
                if (listener.getComparableValue(next).equalsIgnoreCase(listener.getComparableValue(next2))) {
                    transfer.copy(next, next2);
                }
            }
        }
    }
}
