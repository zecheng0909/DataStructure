package com.cheng.queue;

/**
 * Created by cheng on 2018/7/3.
 */

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    /**
     * 默认构造参数
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 构造参数,指定容量
     *
     * @param capacity 容量
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 获取当前 queue 的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 返回 Queue 中的元素个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回 Queue 是否为空
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 向队尾添加一个元素
     *
     * @param element 添加的元素
     */
    @Override
    public void enqueue(E element) {

        if ((tail + 1) % data.length == front)
            reSize(getCapacity() * 2);

        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;

    }

    /**
     * 从队首移除一个元素,并返回
     *
     * @return 移除的元素
     */
    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue fm an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            reSize(getCapacity() / 2);

        return ret;

    }

    /**
     * 返回队首的元素,但并不移除
     *
     * @return 队首的元素
     */
    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        return data[front];
    }

    /**
     * 动态调整队列的容量大小
     *
     * @param newCapacity 容量
     */
    private void reSize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("LoopQueue : size = %d , capacity = %d\n ", size, getCapacity()));
        buffer.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            buffer.append(data[i]);
            if ((i + 1) % data.length != tail) {
                buffer.append(" ,");
            }
        }
        buffer.append("] tail");

        return buffer.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
