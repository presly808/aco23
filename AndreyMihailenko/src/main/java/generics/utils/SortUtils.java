package generics.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by serhii on 11.02.18.
 */
public class SortUtils {

    // todo implement and add generics
    public static <T> List<T> mergeSort(List elements, Comparator comparator){
        if (elements.size() <= 1){
            return elements;
        }
        int mid = elements.size() / 2;
        List<T> left = mergeSort(elements.subList(0, mid), comparator);
        List<T> right = mergeSort(elements.subList(mid, elements.size()), comparator);

        return merge(left, right, comparator);
    }

    public static <T> List<T> merge (List<T> left, List<T> right, Comparator<T> comparator){
        List<T> res = new ArrayList<>();
        int indexL = 0;
        int indexR = 0;
//        int indexRes = 0;

        while (indexL < left.size() || indexR < right.size()){
            if (indexL < left.size() && indexR < right.size()){
                if (comparator.compare(left.get(indexL), right.get(indexR)) < 0){
                    res.add(left.get(indexL));
                    indexL++;
                }
            }
        }
        return res;
    }


    public static <T extends Comparable<T>> int compare(T o1, T o2){
        return o1.compareTo(o2);
    }


}
