package com.cheng.linkedlist;

import com.cheng.queue.Queue;

/**
 * Created by cheng on 2018/8/9.
 */

public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        if (tail == null) {
            head = new Node(element);
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }


        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node ret = head;
        head = head.next;
        ret.next = null;

        if (head == null)
            tail = null;

        size--;

        return ret.element;
    }

    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        return head.element;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");

        Node cursor = head;
        while (cursor.next != null) {
            sb.append(cursor.next.element);
            sb.append(" -> ");
            cursor = cursor.next;
        }

        sb.append("Null tail");
        return sb.toString();
    }

    private class Node {

        public E element;
        public Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}
