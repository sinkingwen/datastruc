package com.gui.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class InffixToSuffix {
    public static void main(String[] args) {
        //符号栈
        Stack<String> stack = new Stack<>();
        //数字列表
        ArrayList<String> numList = new ArrayList();
        String infNotation = "12+2+((200+3)*4)-5";
        ArrayList<String> list = splitNotation(infNotation);
        for (String al : list) {
            if (al.matches("\\d+")) {//操作数
                numList.add(al);
            } else if (al.equals("(")) {//操作符
                stack.push(al);
            } else if (al.equals(")")) {
                while (!stack.peek().equals("(")) {
                    numList.add(stack.pop());
                }
                stack.pop();
            } else {
                while (stack.size() != 0 && Oper.getPriority(al) <= Oper.getPriority(stack.peek())) {
                    numList.add(stack.pop());
                }
                stack.push(al);
            }

        }
        while (stack.size() != 0) {
            numList.add(stack.pop());
        }
        System.out.println(numList);
        int res = PolishNotation.calculate(numList);
        System.out.println(res);
    }

    public static ArrayList<String> splitNotation(String inffix) {
        ArrayList<String> list = new ArrayList();
        int index = 0;
        String str = "";
        int len = inffix.length();
        while (index <= len - 1) {
            str = inffix.substring(index, index + 1);
            if (isOper(str.charAt(0))) {//是运算符
                list.add(str);
            } else {//是操作数,需要判断位数，多位操作数也需要存入数组
                String mulnum = "";
                mulnum += str;
                while (true) {//处理多位数字，对视频代码做了改进
                    if (index == len - 1) {
                        list.add(mulnum);
                        break;
                    } else {
                        if (isOper(inffix.substring(index + 1, index + 2).charAt(0))) {
                            list.add(mulnum);
                            break;
                        } else {
                            String next = inffix.substring(index + 1, index + 2);
                            mulnum += next;
                            index++;
                        }
                    }

                }
            }
            index++;
        }
        return list;
    }

    //判断是否为运算符
    public static boolean isOper(char key) {
        if (key == '+' || key == '-' || key == '*' || key == '/' || key == '(' || key == ')') {
            return true;
        } else {
            return false;
        }
    }
}

class Oper {
    private final static int ADD = 1;
    private final static int SUB = 1;
    private final static int MUL = 2;
    private final static int DIV = 2;

    public static int getPriority(String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("无此运算符~~");
                break;
        }
        return result;
    }
}
