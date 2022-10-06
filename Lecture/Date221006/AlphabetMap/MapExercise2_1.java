package Lecture.Date221006.AlphabetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MapExercise2_1 {
    static boolean isAlphabet(char input) {
        if (((input >= 'a') && (input <= 'z')) || ((input >= 'A') && (input <= 'Z'))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        //String s에 있는 a~z 까지 알파벳의 갯수를 세는 알고리즘
        HashMap<String, Integer> alphabetMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("문장을 입력하시오");
        String input = br.readLine();
        for (char alphabet = 'A'; alphabet <= 'z'; alphabet++) {
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (isAlphabet(input.charAt(i)) && input.charAt(i)==alphabet) {
                    alphabetMap.put(String.valueOf(alphabet).toUpperCase(), ++count);
                }
            }
        }
        for (String key : alphabetMap.keySet()) {
            int value = alphabetMap.get(key);
            System.out.println(key+"는 "+value+"개");
        }

    }
}

