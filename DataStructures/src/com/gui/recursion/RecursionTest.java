package com.gui.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test(1);
    }
    public static void test(int n){
        if(n<4){
            test(n+1);
        }
        System.out.println("n="+n);
    }
}
