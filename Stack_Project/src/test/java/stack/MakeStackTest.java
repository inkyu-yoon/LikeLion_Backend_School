package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MakeStackTest {
    MakeStack stack = new MakeStack();

    @BeforeEach
    void setup() {
        System.out.println("before each 실행");
        //각 테스트 하기전에 실행되는 구현부는 @BeforeEach에 넣기
    }

    @Test
    @DisplayName("getArr() 태스트")
    void getArrTest(){
        // MakeStack은 push,pop,peek 등 직접 Stack의 기능을 구현한 클래스입니다.
        MakeStack stack = new MakeStack();

        //stack 에 10과 20을 push(입력) 하겠습니다.
        stack.push(10);
        stack.push(20);

        //getArr() 메서드를 통해서 배열의 형태로 stack을 반환받아 객체를 생성이 잘 되는지 확인합니다.
        int[] getStack = stack.getArr();

        //getArr() 메서드를 통해 입력받은 getStack의 첫번째 원소는 10 그리고 두번째 원소는 20이어야 기능이 잘 작동하는 것입니다.
        Assertions.assertThat(10).isEqualTo(getStack[0]);
        Assertions.assertThat(20).isEqualTo(getStack[1]);
    }


    @Test
    @DisplayName("push 테스트")
    void 푸쉬테스트() {

        stack.push(100);
        stack.push(200);

        assertThat(100).isEqualTo(stack.getArrById(0));
        assertThat(200).isEqualTo(stack.getArrById(1));
        //junit 말고 assertj 라이브러리 사용
    }

    @Test
    @DisplayName("pop 테스트")
    void popTest() {


        int firstInput = 100;
        int secondInput = 200;

        stack.push(firstInput);
        stack.push(secondInput);

        //스택은 마지막에 입력된게 먼저 나온다.
        assertThat(secondInput).isEqualTo(stack.pop());
        assertThat(firstInput).isEqualTo(stack.pop());
        //push를 2번, pop을 2번 했으므로, 비어있는 상태가 되었다.

        //비어있는 stack을 pop 하게 되면 EmptyStackException 에러가 발생해야함
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("isEmpty 테스트 추가")
    void 이즈엠티기능확인() {

        assertThat(stack.pop()).isEqualTo(null);
    }

    @Test
    void peek테스트() {
        MakeStack stack = new MakeStack();
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }
}