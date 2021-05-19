package org.example;

public class GenericType<T> {

    private T t;

    public GenericType(T t) {
        this.t = t;
    }

    public GenericType() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
