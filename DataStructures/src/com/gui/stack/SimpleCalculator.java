package com.gui.stack;

public class SimpleCalculator {
    public static void main(String[] args) {
        ArrStack numstack = new ArrStack(10);
        ArrStack opersatck = new ArrStack(10);
        int num1, num2, res = 0;
        char c = ' ';
        int index = 0;
        int oper = 0;
        String mulnum = "";
        String notation = "41-3*5+6/2";

        while (true) {
            c = notation.substring(index, index + 1).charAt(0);
            //是否是运算符
            if (opersatck.isOper(c)) {
                if (!opersatck.isEmpty()) {
                    if (opersatck.priority(c) <= opersatck.priority((char) opersatck.peek())) {
                        num1 = numstack.pop();
                        num2 = numstack.pop();
                        oper = opersatck.pop();
                        res = numstack.calc(num1, num2, (char) oper);
                        opersatck.push(c);
                        numstack.push(res);
                    } else {
                        opersatck.push(c);
                    }
                } else {
                    opersatck.push(c);
                }
            } else {//不是运算符
                //numstack.push(c-48);
                mulnum += c;
                if (index == notation.length() - 1) {
                    numstack.push(Integer.parseInt(mulnum));
                } else {
                    if (opersatck.isOper(notation.substring(index + 1, index + 2).charAt(0))) {
                        numstack.push(Integer.parseInt(mulnum));
                        mulnum = "";
                    }
                }
            }
            index++;
            if (index == notation.length()) {
                break;
            }
        }
        while (true) {
            if (opersatck.isEmpty()) {
                break;
            }
            num1 = numstack.pop();
            num2 = numstack.pop();
            oper = opersatck.pop();
            res = numstack.calc(num1, num2, (char) oper);
            numstack.push(res);
        }
        int res2 = numstack.pop();
        System.out.printf("%s = %d", notation, res2);
    }
}

class ArrStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满~~无法入栈");
            return;
        }
        stack[++top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~无法出栈");
        }
        int value = stack[top--];
        return value;
    }

    //查看栈顶元素
    public int peek() {
        return stack[top];
    }

    //遍历
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空~~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //判断是否为运算符
    public boolean isOper(char key) {
        if (key == '+' || key == '-' || key == '*' || key == '/') {
            return true;
        } else {
            return false;
        }
    }

    //定义运算符优先级
    public int priority(char oper) {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }

    //计算结果
    public int calc(int num1, int num2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

}
