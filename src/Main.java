package com.company;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println ("********** Question 1 **********\n");
        int[] arr1 = {4, -5, -3, 1, 2, 7, 0};
        int med1 = 1;
        System.out.println("Checking method 'specialArr' on array "+toString(arr1)+" and med = " + med1);
        int[] studentResult1;
        studentResult1 = Main.specialArr(arr1, med1);
        System.out.println("Result is: "+toString(studentResult1));
        int result=checkIfSpecial(studentResult1);
        if(result>=0)
        {
            System.out.println ("Error!!! The array is not a special array." );
            System.out.println("The first problematic index is : "+result);

        }
        System.out.println();

        int[] arr2 = {4, -5, -3, 1, 2, 7, 9, 0};
        int med2 = 2;
        System.out.println("Checking method 'specialArr' on array "+toString(arr2)+" and med = " + med2);
        int[] studentResult2;
        studentResult2 = Main.specialArr(arr2, med2);

        System.out.println("Result is: "+ toString(studentResult2));
        result=checkIfSpecial(studentResult2);
        if(result>=0)
        {
            System.out.println ("Error!!! The array is not a special array." );
            System.out.println("The first problematic index is : "+result);

        }
        System.out.println();
        System.out.println("Note that these are not the only special arrays that can be created");
        System.out.println();

        System.out.println ("********** Question 2 **********\n");
        int[] arr = new int[]{1, -3, 6, 2, 0, 15};
        System.out.println("Checking method 'first' on array " + toString(arr));
        int studentResult = Main.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{1, 1, 1, 1};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Main.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{1, 2, 3, 4};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Main.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{5, -1, 3, 1, 0, -2, 2};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Main.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{7, 8, 9, 11, 12, 14};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Main.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        System.out.println ("********** Question 3 **********\n");
        int[] array = {1, 1, 4, 10, 10, 4, 3, 10, 10};
        System.out.println("Checking method 'longestNearlyPal' on array " + toString(array));
        int studentResult3 = Main.longestNearlyPal(array);
        System.out.println("Result is: "+studentResult3);
        System.out.println();

        System.out.println ("********** Question 4 **********\n");

        int[][] a={{1,2},{3,4}};
        System.out.println("Checking method 'extreme' on array ");
        print(a);
        int studentResult4 = Main.extreme(a);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

        int[][] b={{1,3},{4,2}};
        System.out.println("Checking method 'extreme' on array ");
        print(b);
        studentResult4 = Main.extreme(b);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

        int[][] c={{4,5,8,2},{3,12,7,16},{13,1,10,14},{15,11,9,6}};
        System.out.println("Checking method 'extreme' on array ");
        print(c);
        studentResult4 = Main.extreme(c);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

        int[][] d={{4,5,8,2},{3,12,16,7},{13,1,10,14},{15,11,9,6}};
        System.out.println("Checking method 'extreme' on array ");
        print(d);
        studentResult4 = Main.extreme(d);
        System.out.println("Result is: "+studentResult4);
        System.out.println();
    }

    public static int[] specialArr(int[] arr, int med) {
        int[] output = arr.clone();
        int counterUp = 1;
        int counterDown = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > med) {
                if (counterDown < arr.length) {
                    output[counterDown] = arr[i];
                    counterDown += 2;
                }
            } else {
                if (counterUp < arr.length) {
                    output[counterUp] = arr[i];
                    counterUp += 2;
                }
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

    public static int longestNearlyPal(int[] arr) {
        return longestNearlyPal(arr, 0, arr.length - 1);
    }
    private static int longestNearlyPal(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (isPalindrome(arr, start, end)) {
            return end - start + 1;
        }
        int removeStart = longestNearlyPal(arr, start + 1, end);
        int removeEnd = longestNearlyPal(arr, start, end - 1);
        return Math.max(removeStart, removeEnd);
    }
    private static boolean isPalindrome(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false;
        }
        return isPalindrome(arr, start + 1, end - 1);
    }

    public static int extreme(int [][] m){
        return extreme(m,0,0,0);
    }

    public static int extreme(int [][] m, int currentX, int currentY, int currentLowVal){
        if (currentX >= m[0].length || currentY >= m.length) {
            return Integer.MAX_VALUE;
        }

        if (currentX < 0 || currentY < 0) {
            return Integer.MAX_VALUE;
        }

        if (m[currentX][currentY] < 0){
            return Integer.MAX_VALUE;
        }

        if (currentX == m[0].length - 1 && currentY == m.length - 1) {
            return currentLowVal;
        }

        currentLowVal = Math.max(currentLowVal, m[currentX][currentY]);

        int temp = m[currentX][currentY];
        m[currentX][currentY] = -1;


        int right = extreme(m, currentX + 1, currentY, currentLowVal);
        int left = extreme(m, currentX - 1, currentY, currentLowVal);
        int down = extreme(m, currentX, currentY + 1, currentLowVal);
        int up = extreme(m, currentX, currentY - 1, currentLowVal);

        m[currentX][currentY] = temp;


        return Math.min(Math.min(right, left), Math.min(down, up));
    }

    public static void swap(int[] array, int first, int second) {
        int helper = array[second];
        array[second] = array[first];
        array[first] = helper;

    }

    private static String toString(int[] arr)
    {
        String s = "{";
        for(int i=0; i<arr.length-1; i++)
            s+=arr[i]+", ";
        return s+arr[arr.length-1]+"}";
    }

    private static void print(int[][] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j = 0; j < arr[i].length-1; j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println(arr[i][arr[i].length-1]);
        }
    }

    private static int checkIfSpecial(int []arr){
        int i;

        for(i=0;i<arr.length-1;i++)
            if(i%2==0)//even place
            {
                if(arr[i]<arr[i+1])//incorrect
                    return i;
            }
            else//odd place
                if(arr[i]>arr[i+1])//incorrect
                    return i;

        return -1;//special array
    }


}
