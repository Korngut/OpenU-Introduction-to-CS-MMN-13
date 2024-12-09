import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[7];
        arr1 = new int[]{  4, -5, -3, 1, 2, 7, 9, 0};
        System.out.println(Arrays.toString(specialArr(arr1, 1)));
        System.out.println(Arrays.toString(new int[]{first(arr1)}));
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
        int[] upperThanMid  = new int[counterUpperAraay];

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
        int counterN = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                counterN++;
            }
        }

        int[] numbersFromN = new int[counterN];
        counterN = 0;

        for (int i = 0; i < numbersFromN.length; i++) {
            if (arr[i] > 0){
                numbersFromN[counterN] = arr[i];
                counterN++;
            }
        }

        for (int i = 0; i < numbersFromN.length; i++) {
            if (i == 0){
                continue;
            }
            else{
                if (numbersFromN[i] - 1 == numbersFromN[i]){
                    warp(numbersFromN, numbersFromN[i], numbersFromN[i-1]);
                }
            }
        }

        int answar = 1;

        for (int i = 0; i < numbersFromN.length; i++) {
            if (answar == numbersFromN[i]){
                break;
            }
            else {
                answar++;
            }
        }

        return answar;

    }

    public static int[] warp(int[] array, int first, int second){
        int helper = array[second];
        array[second] = array[first];
        array[first] = helper;

        return array;
    }
}
