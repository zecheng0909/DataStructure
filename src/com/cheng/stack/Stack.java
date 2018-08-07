package com.cheng.stack;

/**
 * Created by cheng on 2018/6/28.
 */

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E element);

    E pop();

    E peek();

}
