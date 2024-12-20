import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[7];
        arr1 = new int[]{  4, -5, -3, 1, 2, 7, 9, 0};

        System.out.println(Arrays.toString(quickSort(arr1, 0, arr1.length - 1)));
        System.out.println(Arrays.toString(specialArr(arr1, 1)));
        System.out.println(Arrays.toString(new int[]{first(arr1)}));
        System.out.println(funRecursive(23));
    }

    public static int[] specialArr (int[] arr, int med){
        int counterLessAraay = 0;
        int counterUpperAraay = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > med){
                counterUpperAraay++;
            }
            if (arr[i] < med){
                counterLessAraay++;
            }
        }

        int[] lessThanMid = new int[counterLessAraay + 1];
        int[] upperThanMid  = new int[counterUpperAraay]; //

        int counterLess = 0;
        int counterUpper = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < med) {
                lessThanMid[counterLess] = arr[i];
                counterLess++;
            } else if (arr[i] > med) {
                upperThanMid[counterUpper] = arr[i];
                counterUpper++;
            } else {
                lessThanMid[counterLess] = arr[i];
                counterLess++;
            }
        }

        counterLess = 0;
        counterUpper = 0;

        int counterArr = 0;
        int[] output = new int[arr.length];
        while(counterArr < arr.length ){
            if (counterArr % 2 == 0){
                output[counterArr] = lessThanMid[counterLess];
                counterLess++;
                counterArr++;
            }
            else {
                output[counterArr] = upperThanMid[counterUpper];
                counterUpper++;
                counterArr++;
            }
        }

        return output;
    }

    public static int first (int [] arr){
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

    public static void swap(int[] array, int first, int second){
        int helper = array[second];
        array[second] = array[first];
        array[first] = helper;

    }

    public static int funRecursive(int num){
        if (num == 1){
            return 3;
        }
        if (num == 2){
            return 7;
        }
        else {
            return 2* funRecursive(num-1) + funRecursive(num-2);
        }
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
        return arr;
    }


    private static int partition(int[] arr, int left, int right){
        int pivot = arr[right];

        return partitionRecursive(arr, left, right, pivot);
    }

    private static int partitionRecursive(int[] arr, int left, int right, int pivot){
        int i = left - 1;

        if (left >= right){
            return i + 1;
        }

        if (arr[left] <= pivot) {
            i++;
            swap(arr, i, left);
        }

        return partitionRecursive(arr, left + 1, right, pivot);

    }

}
