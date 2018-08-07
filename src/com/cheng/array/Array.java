package com.cheng.array;

/**
 * User: Cheng
 * Date: 2018/06/06 10:17
 * Description: 动态数组
 */

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数,传入数组的容量 capacity 构造 Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 默认构造函数,capacity 为10
     */
    public Array() {
        this(10);
    }

    /**
     * 返回 Array 中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回 Array 的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 向第 index 索引插入一个新的元素
     *
     * @param index   索引
     * @param element 新的元素
     */
    public void add(int index, E element) {

        if (size == data.length)
            reSize(data.length * 2);

        if (index < 0)
            throw new IllegalArgumentException("Add failed. Require index >= 0.");

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;
        size++;
    }

    /**
     * 向数组的首个位置添加一个元素
     *
     * @param element 添加的元素
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * 向数组的最后添加一个元素
     *
     * @param element 添加的元素
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 删除制定索引下的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Delete failed. Index is illegal");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length / 4 && data.length / 2 != 0)
            reSize(data.length / 2);
        return ret;
    }

    /**
     * 删除数组的首个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组的末位元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除 element
     *
     * @param element 删除的元素
     * @return 是否成功删除
     */
    public boolean removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 返回 Array 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回数组是否包含 element
     *
     * @param element 元素
     * @return 是否包含
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element)
                return true;
        }
        return false;
    }

    /**
     * 查找数组中 element 所在的索引,如果不存在 element ,则返回 -1
     *
     * @param element 查找的元素
     * @return 索引
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element)
                return i;
        }
        return -1;
    }

    /**
     * 获取 index 索引位置的元素
     *
     * @param index 索引
     * @return 对应的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    /**
     * 获取首位索引对应的元素
     *
     * @return 对应的元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取末位索引对应的元素
     *
     * @return 对应的元素
     */
    public E getLast() {
        return get(getSize() - 1);
    }

    /**
     * 更新 index 索引位置的元素
     *
     * @param index   索引
     * @param element 新的元素
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        data[index] = element;
    }


    /**
     * 动态调整数组的容量大小
     *
     * @param capacity 容量
     */
    private void reSize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("Array : size = %d , capacity = %d\n ", size, data.length));
        buffer.append('[');
        for (int i = 0; i < size; i++) {
            buffer.append(data[i]);
            if (i != size - 1) {
                buffer.append(',');
            }
        }
        buffer.append(']');

        return buffer.toString();
    }
}

