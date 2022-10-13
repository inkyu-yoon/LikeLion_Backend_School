package October.Lecture.Date221012.Algorithm;

interface Compare {
    boolean action(int valueA, int valueB);
}
public class MaxAndMin {
    private int getMaxOrMinValue(int[] arr,Compare compare) {
        int comparedValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            boolean isSatisfy = compare.action(arr[i],comparedValue);
            if (isSatisfy) {
                comparedValue = arr[i];
            }
        }
        return comparedValue;
    }

    public int max(int[] arr) {
        return getMaxOrMinValue(arr, new Compare() {
            @Override
            public boolean action(int valueA, int valueB) {
                return valueA > valueB;
            }
        });
    }

    public int min(int[] arr) {
        return getMaxOrMinValue(arr, new Compare() {
            @Override
            public boolean action(int valueA, int valueB) {
                return valueA < valueB;
            }
        });
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 29, 38, 12, 57, 74, 40, 85, 61};
        MaxAndMin maxAndMin = new MaxAndMin();
        int max = maxAndMin.max(arr);
        System.out.println(max);

        int min = maxAndMin.min(arr);
        System.out.println(min);
    }
}