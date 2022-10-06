package Lecture.Date221006.AlphabetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MapExercise2 {
    public static void main(String[] args) throws IOException {
        //String s에 있는 a~z 까지 알파벳의 갯수를 세는 알고리즘
        HashMap<String, Integer> alphabetMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("문장을 입력하시오");
        String input = br.readLine();

        for (int i = 65; i <= 90; i++) {
            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                String alphabet = String.valueOf((char) (i));
                String fromSentence = String.valueOf(input.charAt(j)); //equalsIgnoreCase 쓰려고 String으로 변환
                if ((alphabet).equalsIgnoreCase(fromSentence)) {
                    count += 1;
                    alphabetMap.put(alphabet, count);
                }
            }
        }
//        System.out.println(alphabetMap);
        for (String s : alphabetMap.keySet()) {
            int value = alphabetMap.get(s);
            System.out.println(s + " = " + value);
        }


    }

    static boolean isAlphabet(char input) {
        if (((input >= 'a') && (input <= 'z')) || ((input >= 'A') && (input <= 'Z'))) {
            return true;
        }
        return false;
    }
}

