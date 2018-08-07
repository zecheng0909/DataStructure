package com.cheng.stack;

import com.cheng.array.Array;

/**
 * Created by cheng on 2018/6/28.
 */

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    /**
     * 默认构造参数
     */
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 构造参数,指定容量
     *
     * @param capacity 容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 返回 Stack 中的元素个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取当前 Stack 的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 返回 Stack 是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 向栈顶添加一个元素
     *
     * @param element 添加的元素
     */
    @Override
    public void push(E element) {
        array.addLast(element);
    }

    /**
     * 从栈顶取出一个元素,并返回
     *
     * @return 取出的元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 返回栈顶的元素,但并不移除
     *
     * @return 栈顶的元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("Stack : size = %d , capacity = %d\n ", array.getSize(), array.getCapacity()));
        buffer.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            buffer.append(array.get(i));
            if (i != array.getSize() - 1) {
                buffer.append(',');
            }
        }
        buffer.append("] top");

        return buffer.toString();
    }
}
