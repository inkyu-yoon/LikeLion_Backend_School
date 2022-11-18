package October.Lecture.Date221114;

import java.util.*;

class Solution {
    public String solution(String s, int n) {
        //알파벳 26개
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a') {
                sb.append((char) ((ch - 'a' + n) % 26 + 'a'));
            } else if (ch >= 'A') {
                sb.append((char) ((ch - 'A' + n) % 26 + 'A'));
            } else {
                sb.append(" ");
            }
        }
        String answer = sb.toString();
        return answer;
    }
}