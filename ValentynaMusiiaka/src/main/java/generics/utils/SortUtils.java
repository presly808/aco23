package generics.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by serhii on 11.02.18.
 */
public class SortUtils {

    // todo implement and add generics
    public static <T> List<T> mergeSort(List<T> elements, Comparator<T> comparator){

        if(elements.size() <= 1) return elements;

        return merged(
                mergeSort(elements.subList(0, elements.size()/2), comparator),
                mergeSort(elements.subList(elements.size()/2, elements.size()), comparator), comparator);

    }

    private static <T> List<T> merged(List<T> left, List<T> right, Comparator<T> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<T> mergedList = new ArrayList<>();

        while(leftIndex < left.size() && rightIndex < right.size()) {

            if(comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                mergedList.add(left.get(leftIndex++));

            } else {
                mergedList.add(right.get(rightIndex++));
            }
        }

        mergedList.addAll(left.subList(leftIndex, left.size()));
        mergedList.addAll(right.subList(rightIndex, right.size()));

        return mergedList;
    }

    public static <T extends Comparable<T>>int compare(T o1, T o2){
        return o1.compareTo(o2);
    }


}
