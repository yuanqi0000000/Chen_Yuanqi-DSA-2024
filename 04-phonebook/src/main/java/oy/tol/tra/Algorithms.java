package oy.tol.tra;

import java.util.function.Predicate;

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

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {

      int lo = fromIndex, hi = toIndex;
      while (lo <= hi) {
         int mid = lo + (hi - lo) / 2;
         int cmp = aValue.compareTo(fromArray[mid]);
         if (cmp < 0)
            hi = mid - 1;
         else if (cmp > 0)
            lo = mid + 1;
         else
            return mid;
      }
      return -1;
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      quickSort(array, 0, array.length - 1);
   }

   public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
      if (end <= begin)
         return;
      int j = partition(array, begin, end);
      quickSort(array, begin, j - 1);
      quickSort(array, j + 1, end);
   }

   private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {

      int i = begin, j = end + 1;
      E v = array[begin];
      while (true) {
         while (array[++i].compareTo(v) < 0)
            if (i == end)
               break;
         while (v.compareTo(array[--j]) < 0)
            if (j == begin)
               break;
         if (i >= j)
            break;
         swap(array, i, j);
      }
      swap(array, begin, j);
      return j;
   }

   public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {

      int index = 0;
      for (; index < count; index++) {
         if (rule.test(array[index])) {
            break;
         }
      }
      if (index >= count) {
         return count;
      }

      int nextIndex = index + 1;

      while (nextIndex != count) {
         if (!rule.test(array[nextIndex])) {
            swap(array, index, nextIndex);

            index++;
         }
         nextIndex++;
      }
      return index;
   }

}
