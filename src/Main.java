import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1, 1, 10, 4, 3, 10};

        int[][] matrix1 = {
                {4, 5, 8, 2},
                {3, 12, 7, 16},
                {13, 1, 10, 14},
                {15, 11, 9, 6}
        };

        System.out.println(longestNearlyPal(arr1));;
        System.out.println(extreme(matrix1));;

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


    public static int longestNearlyPal (int[] arr){
        return longestNearlyPal(arr, 0, 0, false, 0);
    }

    private static int longestNearlyPal (int[] arr, int index1, int index2, boolean HasOmitted, int currectlength){
        if (index1 > index2){
            return currectlength;
        }

        if (arr[index1] == arr[index2] && !HasOmitted) {
            return longestNearlyPal(arr, index1 + 1, index2 - 1, false, currectlength + 2);
        }

        if (arr[index1] != arr[index2] && !HasOmitted) {
            return Math.max(
                    longestNearlyPal(arr, index1 + 1, index2, true, currectlength),
                    longestNearlyPal(arr, index1, index2 - 1, true, currectlength)
            );
        } else {
            return currectlength;
        }
    }

    public static int extreme(int [][] m){
        return extreme(m,0,0,0);
    }

    public static int extreme(int [][] m, int currentX, int currentY, int currentLowVal){
        int minValue = Math.min(currentLowVal, m[currentY][currentX]);

        if (currentX == m[0].length - 1 && currentY == m.length - 1) {
            return minValue;
        }

        int right = extreme(m, currentX + 1, currentY, minValue);
        int left = extreme(m, currentX - 1, currentY, minValue);
        int down = extreme(m, currentX, currentY + 1, minValue);
        int up = extreme(m, currentX, currentY - 1, minValue);

        return Math.min(Math.min(right, left), Math.min(down, up));
    }

    public static void swap(int[] array, int first, int second) {
        int helper = array[second];
        array[second] = array[first];
        array[first] = helper;

    }

}
