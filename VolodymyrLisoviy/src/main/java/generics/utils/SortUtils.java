package generics.utils;

import java.util.*;

/**
 * Created by serhii on 11.02.18.
 */
public class SortUtils {

    public static <T> List<T> mergeSort(List<T> elements, Comparator<T> comparator) {
        int size = elements.size();
        if (size == 1)
            return elements;

        int middle = size / 2;
        List<T> left = mergeSort(elements.subList(0, middle), comparator);
        List<T> right = mergeSort(elements.subList(middle, size), comparator);

        return merge(left, right, comparator);
    }


    public static <T extends Comparable<T>> int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    private static <T> List<T> merge(List<T> left, List<T> right, Comparator<T> comparator) {
        ListIterator<T> leftItr = left.listIterator();
        ListIterator<T> rightItr = right.listIterator();

        List<T> sortedList = new ArrayList<>();


        while (leftItr.hasNext() && rightItr.hasNext()) {
            Optional<T> leftO = Optional.of(leftItr.next());
            Optional<T> rightO = Optional.of(rightItr.next());

            if (comparator.compare(leftO.get(), rightO.get()) < 0) {
                // left >= right
                sortedList.add(leftO.get());
                rightItr.previous();
            } else {
                // left < right
                sortedList.add(rightO.get());
                leftItr.previous();
            }
        }

        while (leftItr.hasNext()) {
            sortedList.add(leftItr.next());
        }

        while (rightItr.hasNext()) {
            sortedList.add(rightItr.next());
        }

        return sortedList;
    }


}
