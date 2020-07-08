package com.gui.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(6, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("按顺序添加节点后双向链表情况~~");
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.list();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//        System.out.println("添加之后的双向链表情况~~");
//        doubleLinkedList.list();

        System.out.println("修改2号节点之后的双向链表情况~~");
        HeroNode2 h = new HeroNode2(2, "小卢", "玉麒麟~");
        doubleLinkedList.update(h);
        doubleLinkedList.list();

        System.out.println("删除1号节点之后的双向链表情况~~");
        doubleLinkedList.delete(1);
        doubleLinkedList.list();


    }
}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //双向链表添加节点
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.prev = temp;
    }

    //双向链表按顺序添加节点
    public void addByOrder(HeroNode2 heroNode) {
        int flag = 0;//编号，标志是否已有相同编号的节点添加
        HeroNode2 temp = head;//辅助变量
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.prev = temp;
                break;
            }
            if (temp.next.no > heroNode.no) {
                flag = 1;
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = 2;
                break;
            }
            temp = temp.next;
        }
        if (flag == 2) {
            System.out.printf("要添加的节点%d已经存在,不能加入~\n", heroNode.no);
        } else if (flag == 1) {
            heroNode.next = temp.next;
            temp.next.prev = heroNode;
            heroNode.prev = temp;
            temp.next = heroNode;
        }
    }

    //修改双向链表中的节点
    //根据no编号来修改，即no编号不能改
    public void update(HeroNode2 newNode) {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        } else {
            System.out.printf("没有找到编号为 %d 的节点\n", newNode.no);
        }
    }

    //双向链表删除节点，需注意和单向链表是有区别的，双向链表可以自身实现删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除~");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {//已经遍历到链表结尾
                break;
            }
            if (temp.no == no) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                break;
            }
            temp = temp.next;
        }
    }

    //显示链表【遍历双向链表】
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    int no;
    String name;
    String nickname;
    HeroNode2 next;
    HeroNode2 prev;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}