import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[7];
        arr1 = new int[]{4, -5, -3, 1, 2, 7, 9, 0};

        System.out.println(Arrays.toString(specialArr(arr1, 1)));
        System.out.println(Arrays.toString(new int[]{first(arr1)}));
    }

    public static int[] specialArr(int[] arr, int med) {
        int[] output = new int[arr.length];
        int counterUp = 1;
        int counterDown = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > med) {
                output[counterDown] = arr[i];
                counterDown += 2;
            }

            if (arr[i] <= med) {
                output[counterUp] = arr[i];
                counterUp += 2;
            }
        }


        return output;
    }

    public static int first(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr.length && arr[i] >= 1 && arr[i] - 1 != i) {
                swap(arr, arr[i] - 1, i);
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if (arr[i - 1] != i) {
                return i;
            }
        }


        return arr.length;

    }

    public static void swap(int[] array, int first, int second) {
        int helper = array[second];
        array[second] = array[first];
        array[first] = helper;

    }

}
