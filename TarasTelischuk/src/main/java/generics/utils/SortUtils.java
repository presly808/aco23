package generics.utils;

import java.util.*;

/**
 * Created by serhii on 11.02.18.
 */
public class SortUtils {

    // todo implement and add generics

    public static <T>List<T> mergeSort(List<T> elements, Comparator comparator) {

       List<T> sortedLst = new LinkedList<>(elements);
       Collections.sort(sortedLst, comparator);
       return sortedLst;
    }

    public static  <T extends Comparable<T>> int compare(T o1, T o2){

        return o1.compareTo(o2);
    }
}
