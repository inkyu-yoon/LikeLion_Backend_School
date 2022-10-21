package stack;

import java.util.EmptyStackException;

public class MakeStack {
    private int[] stack;
    private int pointer = -1;

    //size 지정 안할 시 10000으로 잡음
    public MakeStack() {
        this.stack = new int[10000];
    }

    //스택 사이즈 직접 지정
    public MakeStack(int size) {

        this.stack = new int[size];
    }

    //스택에 값 집어넣기
    public void push(int value) {

        this.stack[++this.pointer] = value;
    }

    //스택 배열 반환하기
    public int[] getArr() {

        return this.stack;
    }

    //특정 인덱스를 지정해서 값 반환하기
    public int getArrById(int index) {
        return stack[index];
    }

    public int[] getArr(int index) {
        return stack;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[pointer--];
    }

    public boolean isEmpty() {
        if (pointer == -1) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[pointer];
    }
    public int 안녕(){
        return 1;
    }
}
