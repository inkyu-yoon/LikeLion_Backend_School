import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    @DisplayName("스택 안쓰고")
    void solution() {
        Assertions.assertFalse(solution.solution("{}()[](({))"));
        Assertions.assertTrue(solution.solution("{}()[](({}))"));
    }

    @Test
    @DisplayName("replace로")
    void solution2() {
        Assertions.assertFalse(solution.solution2("{}()[](({))"));
        Assertions.assertTrue(solution.solution2("{}()[](({}))"));
    }

    @Test
    @DisplayName("스택으로")
    void solution3() {
        Assertions.assertFalse(solution.solution3("{}()[](({{))"));
        Assertions.assertTrue(solution.solution3("{}()[](({}))"));
        Assertions.assertFalse(solution.solution3("{]"));
    }
}