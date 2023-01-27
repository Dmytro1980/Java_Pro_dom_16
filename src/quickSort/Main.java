package quickSort;

public class Main {
    public static void main(String[] args) {
        int[] array = fillArray(30);

        // вывод массива
        for (int i : array) System.out.print(i + " ");
        System.out.println();

        quickSort(array, 0, array.length - 1);

        // вывод массива
        for (int i : array) System.out.print(i + " ");
        System.out.println();
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

    public static int[] fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + (Math.random()) * 100);
        }
        return array;
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
}