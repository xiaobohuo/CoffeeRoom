package com.dom.ination.coffeeroom.stack;

import java.util.Arrays;

/**
 * Created by huoxiaobo on 2017/3/13.
 */

public class CoffeStack<E> {
    Object[] stack;
    int size;

    public CoffeStack() {
        stack = new Object[10];
    }

    public E peek() {
        return (E) stack[size - 1];
    }

    public void push(E obj) {
        ensureCapacity(size + 1);
        stack[size] = obj;
        size++;
    }

    private void ensureCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            stack = Arrays.copyOf(stack, len * 2);
            System.out.println("capacity larger");
        }
    }

    public E pop() {
        E obj = peek();
        stack[size - 1] = null;
        size--;
        return obj;
    }

    public void printStack() {
        for (int i = 0; i < stack.length; i++) {
            System.out.println(stack[i] + "");
        }
    }

    public static void main(String[] args) {
        CoffeStack<String> stack = new CoffeStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        stack.push("11");
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
    }
}
