package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @Test
    @DisplayName("push 테스트")
    void 푸쉬테스트() {
        StackImpl stack = new StackImpl();
        stack.push(100);
        stack.push(200);
        Assertions.assertEquals(stack.getArrById(0), 100);
        Assertions.assertEquals(stack.getArrById(1), 200);
    }

    @Test
    @DisplayName("push & pop 테스트")
    void 푸쉬랑팝테스트() {
        StackImpl stack = new StackImpl();
        int firstInput = 100;
        int secondInput = 200;
        stack.push(firstInput);
        stack.push(secondInput);


        Assertions.assertEquals(secondInput, stack.pop());
        Assertions.assertEquals(firstInput, stack.pop());


    }
}