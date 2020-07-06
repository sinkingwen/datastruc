package com.gui.queue;

import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        ArrayQueue arrayQueue = new ArrayQueue(4);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("g(get):出队列");
            System.out.println("h(head):查看队列头元素");
            System.out.println("a(add):添加数据到队列");
            System.out.println("e(exit):退出");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'g':
                    try{
                        System.out.printf("取出的数据是:%d\n",arrayQueue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        System.out.printf("队列头数据是:%d\n",arrayQueue.headQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arraySize) {
        maxSize = arraySize;
        arr = new int[arraySize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满~");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    public void showQueue(){
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列是空的，什么数据也没有~");
        }
        front++;
        return arr[front];
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列是空的，什么数据也没有~");
        }
        return arr[front+1];
    }

}
