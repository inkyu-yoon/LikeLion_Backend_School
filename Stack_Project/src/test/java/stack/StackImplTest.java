package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @Test
    @DisplayName("push 테스트")
    void 푸쉬테스트(){
        StackImpl stack = new StackImpl();
        stack.push(100);
        stack.push(200);
        Assertions.assertEquals(stack.getArrById(0),100);
        Assertions.assertEquals(stack.getArrById(1),200);
    }
}