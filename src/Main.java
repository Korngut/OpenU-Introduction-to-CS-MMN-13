/**
 Solution - MMN 13

 @version 2025a
 @author Ori Korngut - 218666568
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     Gets an array and turns it into a special array.
     O(N) space complexity,
     O(N) time complexity

     @param arr The array that must be turned into a special array
     @param med The median in the given array
     @return An array with the same values, but in the form of a special array
     */

    public static int[] specialArr (int[] arr, int med){
        int[] newArr = new int[arr.length];
        int counterOdd = 1;
        int counterEven = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= med) {
                newArr[counterEven] = arr[i];
                counterEven += 2;
            }
            else{
                newArr[counterOdd] = arr[i];
                counterOdd += 2;
            }
        }

        return newArr;
    }

    /**
     Gets an array and returns the first natural number that does not appear in the array
     O(1) space complexity,
     O(N) time complexity

     @param arr The array in which to find the number
     @return The first natural number not in the array
     */

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
        return arr.length + 1;

    }

    /**
     Gets an array and returns the first natural number that does not appear in the array
     O(1) space complexity,
     O(N) time complexity

     @param arr The array in which to find the number
     @return The first natural number not in the array
     */
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

}
