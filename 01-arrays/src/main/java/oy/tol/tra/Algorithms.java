package oy.tol.tra;

public class Algorithms {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j > 0) && (array[j].compareTo(array[j - 1]) < 0); j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static <T> void reverse(T[] array) {
        int i = 0;
        while (i <= (array.length - 1) / 2) {
            swap(array, i, array.length - i - 1);
            i++;
        }
    }

    public static <T> void swap(T[] array, int i, int j) {
        T tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
