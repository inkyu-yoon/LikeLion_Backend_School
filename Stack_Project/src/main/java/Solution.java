import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||s.charAt(i) == '['||s.charAt(i) == '{') {
                a += 1;
            } else {
                a -= 1;
            }
            if (a < 0) {
                return false;
            }
        }
        if (a == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean solution2(String s) {
        while (s.indexOf("()") >= 0 ||s.indexOf("[]") >= 0||s.indexOf("{}") >= 0) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.length() == 0;
    }

    boolean solution3(String s) {
        Stack<Character> stack = new Stack<>();
        char[] bracket = {'(','[','{'};
        char[] bracket2 = {')',']','}'};

        try {
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < bracket.length; j++) {
                    if (s.charAt(i) == bracket[j]) {

                        stack.push(bracket[j]);
                    } else if(s.charAt(i)==bracket2[j]){
                        if(stack.search(bracket[j])>=0){
                            stack.pop();
                        }
                    }
                }

            }
        }catch (Exception e){
            return false;
        }

        return stack.size()==0;


    }
}