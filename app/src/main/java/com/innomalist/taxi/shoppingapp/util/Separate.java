package com.innomalist.taxi.shoppingapp.util;

import java.util.List;

public class Separate<T> {
    Include<T> include;
    List<T> list;
    Listener<T> listener;
    String separator;

    public interface Include<T> {
        boolean shouldInclude(T t);
    }

    public interface Listener<T> {
        String getString(T t);
    }

    public Separate(List<T> list2, String str, Listener<T> listener2) {
        this.list = list2;
        this.separator = str;
        this.listener = listener2;
    }

    public Separate(List<T> list2, String str, Listener<T> listener2, Include<T> include2) {
        this.list = list2;
        this.separator = str;
        this.listener = listener2;
        this.include = include2;
    }

    public String getValue() {
        String str = "";
        String str2 = str;
        for (T next : this.list) {
            Include<T> include2 = this.include;
            if (include2 == null || include2.shouldInclude(next)) {
                str = str + str2 + this.listener.getString(next);
                str2 = this.separator;
            }
        }
        return str;
    }
}
