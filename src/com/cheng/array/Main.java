package com.cheng.array;

/**
 * User: Cheng
 * Date: 2018/06/06 10:21
 * Description:
 */

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array(14);
        for (int i = 0; i < 9; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());

        array.removeLast();
        array.removeLast();
        System.out.println(array.toString());
    }
}
