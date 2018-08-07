package com.cheng;

import com.cheng.queue.ArrayQueue;
import com.cheng.queue.LoopQueue;
import com.cheng.queue.Queue;

import java.util.Random;

/**
 * Created by cheng on 2018/8/6.
 */

public class Main {

    private static double testQueue(Queue<Integer> queue, int count) {

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < count; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < count; i++)
            queue.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000F;
    }

    public static void main(String[] args) {
        int count = 100000;

        double time1 = testQueue(new ArrayQueue<>(), count);
        System.out.println("ArrayQueue time : " + time1);

        double time2 = testQueue(new LoopQueue<>(), count);
        System.out.println("LoopQueue time : " + time2);
    }
}
