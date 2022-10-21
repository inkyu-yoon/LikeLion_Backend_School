class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
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
        while (s.indexOf("()") >= 0) {
            s = s.replace("()", "");
        }
        return s.length() == 0;
    }
}