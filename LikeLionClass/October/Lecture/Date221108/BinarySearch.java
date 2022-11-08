package October.Lecture.Date221108;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        int target = 8;
        int start = 0;
        int end = nums.length-1;

        while (true) {
            //중간값 찾기
            int midPoint = (start + end) / 2;

            if (nums[midPoint] > target) {
                end = midPoint-1;
            } else if(nums[midPoint]<target) {
                start = midPoint+1;
            } else if (nums[midPoint] == target) {
                System.out.println("index : "+midPoint);
                break;
            }
        }
    }
}
