package com.gui.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //添加节点
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        singleLinkedList.list();

        //反转节点
        reverseList(singleLinkedList.getHead());
        System.out.println("反转后的链表情况~~");
        singleLinkedList.list();
/*
        //按照节点顺序添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newNode = new HeroNode(2, "卢~", "玉麒麟~~");
        singleLinkedList.update(newNode);
        System.out.println("修改后的链表情况~");
        singleLinkedList.list();

        //测试删除链表的代码
        singleLinkedList.delete(2);
        System.out.println("删除节点后链表情况~");
        singleLinkedList.list();
 */

    }

    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量，帮助我们遍历原来的链表
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (temp != null) {
            next = temp.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            temp.next = reverseHead.next;//将当前节点temp的下一个节点指向新的链表的最前端
            reverseHead.next = temp;//将当前节点连接到新的链表上

            temp = next;//将当前节点后移
        }
        head.next = reverseHead.next;//将head.next 指向 reverseHead.next, 实现单链表的反转
    }
}

class SingleLinkedList {
    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        boolean flag = false;//编号，标志是否已有相同编号的节点添加
        HeroNode temp = head;//辅助变量
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("要添加的节点%d已经存在,不能加入~\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
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

    //删除节点信息
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {//已经遍历到链表结尾
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //显示链表【遍历】
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode {
    int no;
    String name;
    String nickname;
    HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}