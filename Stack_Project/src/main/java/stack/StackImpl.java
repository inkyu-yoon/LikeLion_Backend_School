package stack;

public class StackImpl {
    private int[] stack;

    //size 지정 안할 시 10000으로 잡음
    public StackImpl() {
        this.stack = new int[10000];
    }
    //스택 사이즈 직접 지정
    public StackImpl(int size) {
        this.stack = new int[size];
    }

    //스택에 값 집어넣기
    public int[] push(int value) {
        stack[0] = value;
        return stack;
    }

    //스택 배열 반환하기
    public int[] getStack() {
        return stack;
    }

    //특정 인덱스를 지정해서 값 반환하기
    public int getArrById(int index){
        return stack[index];
    }
}
