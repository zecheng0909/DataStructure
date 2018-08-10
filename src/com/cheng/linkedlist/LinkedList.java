package com.cheng.linkedlist;

/**
 * Created by cheng on 2018/8/7.
 */

public class LinkedList<E> {

    private int size;
    private Node dummyHead;

    LinkedList() {
        size = 0;
        dummyHead = new Node(null, null);
    }

    /**
     * 返回 LinkedList 中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回 LinkedList 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向 LinkedList 的 index 索引添加一个元素
     *
     * @param index   索引
     * @param element 添加的元素
     */
    public void add(int index, E element) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(element, prev.next);
        size++;
    }

    /**
     * 向 LinkedList 的首个位置添加一个元素
     *
     * @param element 添加的元素
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * 向 LinkedList 的末位添加一个元素
     *
     * @param element 添加的元素
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 获取 index 索引的元素
     *
     * @param index 索引
     * @return 对应的元素
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
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
        return get(size);
    }

    /**
     * 修改 index 索引对应的元素
     *
     * @param index   修改的索引
     * @param element 新的元素
     */
    public void set(int index, E element) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = element;
    }

    /**
     * 删除制定索引下的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.element;
    }

    /**
     * 删除 LinkedList 的首个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除 LinkedList 的末位元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查询 LinkedList 是否存在 element 这个元素
     *
     * @param element 查询的元素
     * @return 是否存在
     */
    public boolean contains(E element) {

        Node current = dummyHead.next;
        while (current.next != null) {
            if (current.element == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        Node cursor = dummyHead;
        while (cursor.next != null) {
            sb.append(cursor.next.element);
            sb.append(" -> ");
            cursor = cursor.next;
        }
        sb.append("Null");
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
