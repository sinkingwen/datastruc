package com.gui.queue;

import java.util.Scanner;

public class CircleQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        ArrayCircleQueue arrayQueue = new ArrayCircleQueue(4);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("g(get):出队列");
            System.out.println("h(head):查看队列头元素");
            System.out.println("a(add):添加数据到队列");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'g':
                    try {
                        System.out.printf("取出的数据是:%d\n", arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.printf("队列头数据是:%d\n", arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~");
    }
}

class ArrayCircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayCircleQueue(int arrSize) {
        maxSize = arrSize;
        arr = new int[arrSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public void showQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，什么数据也没有~");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，什么数据也没有~");
        }
        return arr[front % maxSize];
    }
}