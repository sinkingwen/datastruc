package com.gui.stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        LinkedListStack lls = new LinkedListStack();
        lls.push(node1);
        lls.push(node2);
        lls.push(node3);

        lls.showStack();

        Node n = lls.pop();
        System.out.println("出栈节点是"+n.getNo());

        lls.showStack();
    }
}

class LinkedListStack {
    private Node top = new Node(-1);

    public Node getTop() {
        return top;
    }

    public boolean isEmpty() {
        return top.getNext()== null;
    }

    //入栈
    public void push(Node node){
        if(top.getNext()==null){
            top.setNext(node);
            return;
        }
        Node temp=top.getNext();
        top.setNext(node);
        node.setNext(temp);
    }

    //出栈
    public Node pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空~~无法出栈");
        }
        Node n = top.getNext();
        top = top.getNext();
        return n;
    }

    //遍历
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈为空~~");
            return;
        }
        Node temp = top.getNext();
        while(temp!=null){
            System.out.printf("%d\t",temp.getNo());
            temp = temp.getNext();
        }

    }

}

class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Node getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
