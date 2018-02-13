package generics.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class SortUtils {

    // todo implement and add generics
    public static <E> List mergeSort(List elements, Comparator comparator){

        E[] array = (E[]) elements.toArray();
        mergeSort(array, 0, array.length - 1, comparator);

        return Arrays.asList(array);
    }

    private static <E> void mergeSort(E[] a, int from, int to, Comparator<? super E> comp) {
        if (from == to)
            return;
        int mid = (from + to) / 2;
        // Sort the first and the second half
        mergeSort(a, from, mid, comp);
        mergeSort(a, mid + 1, to, comp);
        merge(a, from, mid, to, comp);
    }


    private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {

        int n = to - from + 1;

        Object[] values = new Object[n];

        int fromValue = from;
        int middleValue = mid + 1;
        int index = 0;

        while (fromValue <= mid && middleValue <= to) {
            if (comp.compare(a[fromValue], a[middleValue]) < 0) {
                values[index] = a[fromValue];
                fromValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }

        while (fromValue <= mid) {
            values[index] = a[fromValue];
            fromValue++;
            index++;
        }
        while (middleValue <= to) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }

        for (index = 0; index < n; index++) {
            a[from + index] = (E) values[index];
        }
    }


    public static <T extends Comparable<T>> int compare(T o1, T o2){
        return o1.compareTo(o2);
    }
}