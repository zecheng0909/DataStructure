package com.cheng.queue;

import com.cheng.array.Array;

/**
 * Created by cheng on 2018/7/2.
 */

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 默认构造参数
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 构造参数,指定容量
     *
     * @param capacity 容量
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 返回 Queue 中的元素个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取当前 Queue 的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 返回 Queue 是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 向队尾添加一个元素
     *
     * @param element 添加的元素
     */
    @Override
    public void enqueue(E element) {
        array.addLast(element);
    }

    /**
     * 从队首移除一个元素,并返回
     *
     * @return 移除的元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 返回队首的元素,但并不移除
     *
     * @return 队首的元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("Queue : size = %d , capacity = %d\n ", array.getSize(), array.getCapacity()));
        buffer.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            buffer.append(array.get(i));
            if (i != array.getSize() - 1) {
                buffer.append(',');
            }
        }
        buffer.append("] tail");

        return buffer.toString();
    }
}
