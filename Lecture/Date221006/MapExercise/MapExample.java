package Lecture.Date221006.MapExercise;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        NameAndGithub nameAndGithub = new NameAndGithub();
        HashMap<String, String> map = nameAndGithub.getMap();
        for (String s : map.keySet()) {
            String value = map.get(s);
            System.out.println(s+" || " +value);
        }

    }

}
