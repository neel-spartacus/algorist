package com.scaler.queues;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class TaskScheduling {

    public static int solve(int[] A, int[] B) {

        int count=0;
        Queue<Integer> schedulerQueue = new ArrayDeque<>();
        Queue<Integer> taskQueue = new ArrayDeque<>();
        for (int item : A) {
            schedulerQueue.add(item);
        }
        for (int task : B) {
            taskQueue.add(task);
        }

        while (!taskQueue.isEmpty()){
            int task=taskQueue.poll();
            while (task!=schedulerQueue.peek()){
                int scheduleTask= schedulerQueue.poll();
                count++;
                schedulerQueue.add(scheduleTask);
            }
            count++;
            schedulerQueue.poll();
        }

        return count;

    }
    public static void main(String[] args) {
        int[] A={2, 3, 1, 5, 4};
        int[] B={1, 3, 5, 4, 2};
        System.out.println(solve(A,B));

    }
}
