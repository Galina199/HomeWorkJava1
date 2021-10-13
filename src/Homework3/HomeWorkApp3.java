package Homework3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        int length = 8;
        int initialValue = 10;
        int[] array = initArray(length, initialValue);
        System.out.println(Arrays.toString(array));
        getArr();
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{4, 6, 8, 5}));
        System.out.println(checkBalance(new int[]{1, 5, 7, 9, 3}));
    }


    public static void invertArray() {
        int[] array = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));

    }
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = (i == j || j == (6 - i - 1)) ? 1 : (int) (Math.random() * 100);
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
    private static int[] initArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
    public static void getArr() {
        int[] arr = {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 5};
        int min = arr[0], max = arr[0], i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];

            }
            if (arr[i] > max) {
                max = arr[i];

            }
            System.out.println("Max = " + max);
            System.out.println("Min = " + min);
        }
    }


    public static boolean checkBalance (int[] array) {
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
            int rightSum = 0;
            for (int j = 0; j < array.length; j++) {
                rightSum += (j > i) ? array[j] : 0;
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }
//Задание 8 выполнить не получилось.
}
