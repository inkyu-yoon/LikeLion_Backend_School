package October.Lecture.Date221108;

import java.io.*;

public class SimpleSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split(" ");
        int find = Integer.valueOf(br.readLine());
        int answer = -1;
        for (int i = 0; i < input.length; i++) {
            if (Integer.valueOf(input[i]) == find) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);
    }
}
