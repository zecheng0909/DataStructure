package com.cheng.linkedlist;

import com.cheng.stack.Stack;

/**
 * Created by cheng on 2018/8/9.
 */

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E element) {
        linkedList.addFirst(element);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
}
