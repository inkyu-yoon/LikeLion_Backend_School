package October.Lecture.Date221108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
3 7
2 5 7

3
 */
public class BSCodeUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.valueOf(input[0]);
        int target = Integer.valueOf(input[1]);
        String[] arr = br.readLine().split(" ");
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            //범위 안에 아예 없는 경우
            int midPoint = (start + end) / 2;
            int midValue = Integer.valueOf(arr[midPoint]);

            if (midValue < target) {
                start = midPoint + 1;
            } else if (midValue > target) {
                end = midPoint - 1;
            } else {
                System.out.println(midPoint+1);
                return;
            }

        }
        System.out.println(-1);


    }

}

