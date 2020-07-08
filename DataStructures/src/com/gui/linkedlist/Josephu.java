package com.gui.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        int nums = 15;
        CircleSingleLinkedList csl = new CircleSingleLinkedList();
        csl.addBoy(nums);
        csl.show(csl.getFirst());

        System.out.println("出圈顺序如下~~");
        csl.countBoy(1, 3, nums);

    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public Boy getFirst() {
        return first;
    }

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入不正确！");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                cur = first;//让cur指向第一个小孩
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    //小孩出圈

    /**
     * @param startNo 从第几个小孩开始数数
     * @param k       数几次
     * @param nums    小孩的个数
     */
    public void countBoy(int startNo, int k, int nums) {
        //首先要对输入的数据进行校验
        if (startNo < 0 || k > nums || nums == 0) {
            System.out.println("输入的数据有误，请重新输入！");
            return;
        }
        Boy cur = first;
        while (true){
            if(cur.getNext()==first){
                break;
            }
            cur=cur.getNext();
        }
        //从第startNo个小孩开始数数，first和cur指针需要移动
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            cur = cur.getNext();
        }
        while (true) {
            if (cur == first) {
                break;
            }
            for (int j = 0; j < k - 1; j++) {
                first = first.getNext();
                cur = cur.getNext();
            }
            System.out.printf("第 %d 个孩子出圈\n", first.getNo());
            first = first.getNext();
            cur.setNext(first);
        }
        System.out.println("最后一个出圈的孩子是 " + cur.getNo());

    }

    public void show(Boy first) {
        if (first == null) {
            System.out.println("还没有小孩~~");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("第 %d 个小孩儿\n", cur.getNo());
            cur = cur.getNext();
            if (cur == first) {
                break;
            }
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}