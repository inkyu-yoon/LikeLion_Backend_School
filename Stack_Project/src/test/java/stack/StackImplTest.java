package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @BeforeEach
    void setup() {
        System.out.println("before each 실행");
        //각 테스트 하기전에 실행되는 구현부는 @BeforeEach에 넣기
    }


    @Test
    @DisplayName("push 테스트")
    void 푸쉬테스트() {
        StackImpl stack = new StackImpl();
        stack.push(100);
        stack.push(200);

        assertThat(100).isEqualTo(stack.getArrById(0));
        assertThat(200).isEqualTo(stack.getArrById(1));
        //junit 말고 assertj 라이브러리 사용
    }

    @Test
    @DisplayName("pop 테스트")
    void 팝테스트() {
        StackImpl stack = new StackImpl();
        int firstInput = 100;
        int secondInput = 200;
        stack.push(firstInput);
        stack.push(secondInput);

        assertThat(secondInput).isEqualTo(stack.pop());
        assertThat(firstInput).isEqualTo(stack.pop());
        //스택은 마지막에 입력된게 먼저 나온다.
    }

    @Test
    @DisplayName("isEmpty 테스트 추가")
    void 이즈엠티기능확인(){
        StackImpl stack = new StackImpl();
        assertThat(stack.pop()).isEqualTo(null);
    }
}