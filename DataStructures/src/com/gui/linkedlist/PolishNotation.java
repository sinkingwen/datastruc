package com.gui.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class PolishNotation {
    public static void main(String[] args) {
        String suffix = "3 42 * 5 + 2 / 7 - 9 +";
        ArrayList<String> al = getSuffixNotation(suffix);
        System.out.println(al);
        int res = calculate(al);
        System.out.printf("%s = %d", suffix, res);
    }

    public static ArrayList<String> getSuffixNotation(String suffix) {
        ArrayList<String> list = new ArrayList();
        String[] str = suffix.split(" ");
        for (String item : str) {
            list.add(item);
        }
        return list;
    }

    public static int calculate(ArrayList<String> arrayList) {
        Stack<String> stack = new Stack<>();
        int res = 0, num1 = 0, num2 = 0;
        for (String var : arrayList) {
            if (var.matches("\\d+")) {
                stack.push(var);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                if (var.equals("+")) {
                    res = num1 + num2;
                } else if (var.equals("-")) {
                    res = num2 - num1;
                } else if (var.equals("*")) {
                    res = num1 * num2;
                } else if (var.equals("/")) {
                    res = num2 / num1;
                } else {
                    System.out.println("操作符不识别~~");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}


