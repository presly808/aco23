package generics.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by serhii on 11.02.18.
 */
public class SortUtils {

    // todo implement and add generics
    public static <E>List<E> mergeSort(List<E> elements, Comparator<E> comparator){
        int size = elements.size();
        if (size == 1)
            return elements;

        int middle = size / 2;
        List<E> left = mergeSort(elements.subList(0, middle), comparator);
        List<E> right = mergeSort(elements.subList(middle, size), comparator);

        return merge(left, right, comparator);
    }


    public static <E extends Comparable<E>> int compare(E o1, E o2){
        return o1.compareTo(o2);
    }

    private static <E>List<E> merge(List<E> left, List<E> rigth, Comparator comparator) {
        List<E> ret = new ArrayList<>();
        int left_idx = 0, right_idx = 0;

        while(left_idx+1 <= left.size() || right_idx+1 <= rigth.size()) {
            if(left_idx+1 <= left.size() && right_idx+1 <= rigth.size()) {
                if(comparator.compare(left.get(left_idx),rigth.get(right_idx)) <= 0) {
                    ret.add(left.get(left_idx));
                    left_idx++;
                } else {
                    ret.add(rigth.get(right_idx));
                    right_idx++;
                }
            } else if(left_idx+1 <= left.size()) {
                ret.add(left.get(left_idx));
                left_idx++;
            } else if(right_idx+1 <= rigth.size()) {
                ret.add(rigth.get(right_idx));
                right_idx++;
            }
        }

        return ret;
    }


}
