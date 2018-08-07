package com.cheng.queue;

/**
 * Created by cheng on 2018/7/2.
 */

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue();

    E getFront();

}
