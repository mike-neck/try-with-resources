package org.mikeneck.twr.util;

/**
 * @author mike
 */
public class DataPattern<W, T> {

    private W c;

    private T r;

    protected DataPattern(W when) {
        this.c = when;
    }

    @SuppressWarnings("unchecked")
    public static <W> DataPattern when (W w) {
        return new DataPattern(w);
    }

    public DataPattern then (T r) {
        this.r = r;
        return this;
    }

    public W condition () {
        return c;
    }

    public T result () {
        return r;
    }

    @Override
    public String toString() {
        return "condition [" +
                c +
                ", result [" + r +
                ']';
    }
}
