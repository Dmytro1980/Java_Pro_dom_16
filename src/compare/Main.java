package compare;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = fillArray(100000);

        int[] arr01 = Arrays.copyOf(array, array.length);
        int[] arr02 = Arrays.copyOf(array, array.length);

        long timeStart = System.currentTimeMillis();
        quickSort(arr01, 0, arr01.length-1);
        long timeFinish = System.currentTimeMillis();
        System.out.println(timeFinish - timeStart);

        timeStart = System.currentTimeMillis();
        shakerSort(arr02);
        timeFinish = System.currentTimeMillis();
        System.out.println(timeFinish - timeStart);

    }

    public static int[] fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + (Math.random()) * 100);
        }
        return array;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (array.length == 0) {
            System.out.println("array is empty");
        }

        if (begin < end) {
            int opElement = delenie(array, begin, end);
            quickSort(array, begin, opElement - 1);
            quickSort(array, opElement, end);
        }
    }

    private static int delenie(int[] array, int begin, int end) {

        int leftIndex = begin;
        int rightIndex = end;

        int opElement = array[begin + (end - begin) / 2];

        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < opElement) {
                leftIndex++;
            }
            while (array[rightIndex] > opElement) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {

                int temp = array[rightIndex];
                array[rightIndex] = array[leftIndex];
                array[leftIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    static void shakerSort(int[] array) {
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            left++;
        } while (left < right);
    }

}
